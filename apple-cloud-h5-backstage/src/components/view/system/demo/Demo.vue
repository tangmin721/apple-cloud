<template>
  <el-container>
    <div class="header-box">
      <el-header header-align="left">
        <div class="header-wrap">
          <div class="btn-group">
            <el-button-group>
              <el-button type="primary" icon="el-icon-circle-plus" @click="handleCreate">新增
              </el-button>
              <el-button v-waves type="success" icon="el-icon-edit" @click="handleTopUpdate">修改
              </el-button>
              <el-button v-waves type="danger" icon="el-icon-delete" @click="handleBatchDelete">删除
              </el-button>
            </el-button-group>
          </div>
          <div class="search-form">
            <el-form
              :model="searchForm"
              class="module-form-inline"
              align="left"
              ref="searchForm"
              v-show="!isShowMoreForm">
              <demo-search :searchForm="searchForm"></demo-search>
            </el-form>
            <transition name="slide-up">
              <div class="form-more-box"
                v-show="isShowMoreForm">
                <i class="el-icon-circle-close-outline" @click="handleMoreForm"></i>
                <demo-search :searchForm="searchForm"></demo-search>
                <el-button-group v-show="isShowMoreForm">
                  <el-button v-waves type="primary" icon="el-icon-search" @click="getList">搜索 </el-button>
                  <el-button v-waves type="warning" icon="el-icon-delete" @click="handleClearSearch">清空</el-button>
                  <el-button type="danger" plain icon="el-icon-circle-close-outline" @click="isShowMoreForm=!isShowMoreForm">关闭</el-button>
                </el-button-group>
              </div>
            </transition>
          </div>
          <div>
            <el-button-group v-show="!isShowMoreForm">
              <el-button v-waves type="primary" icon="el-icon-search" @click="getList">搜索 </el-button>
              <el-tooltip content="更多搜索条件" placement="top">
                <el-button type="primary" icon="el-icon-d-arrow-right" @click="handleMoreForm" v-show="isShowMoreBtn"></el-button>
              </el-tooltip>
              <el-button v-waves type="warning" icon="el-icon-delete" @click="handleClearSearch"> 清空 </el-button>
            </el-button-group>
          </div>
        </div>

        <demo-form
          :dialogStatus="dialogStatus"
          :dialogFormVisible="dialogFormVisible"
          :ruleForm="ruleForm"
          @closeDialogForm="closeDialogForm"
          @toggleGetList="getList"
        ></demo-form>
      </el-header>
    </div>

    <el-main>
      <el-table
        ref="multipleTable"
        :data="list"
        v-loading="loading"
        element-loading-text="拼命加载中"
        empty-text="暂无数据"
        highlight-current-row
        stripe
        @sort-change="sortChange"
        @selection-change="handleSelectionChange"
        :max-height="maxHeight"
        :height="maxHeight"
        style="width:100%;"
      >
        <el-table-column type="selection" width="14px" style="padding: 0 5px" fixed/>
        <el-table-column width="20px" align="center" type="expand" fixed>
          <template slot-scope="scope">
            <el-form label-position="left" inline class="module-table-expand">
              <el-form-item label="id" sortable="custom">
                <span>{{ scope.row.id }}</span>
              </el-form-item>
              <el-form-item label="版本号" width="200px">
                <span>{{ scope.row.version }}</span>
              </el-form-item>
              <el-form-item label="创建人id">
                <span>{{ scope.row.createUserId }}</span>
              </el-form-item>
              <el-form-item label="创建人">
                <span>{{ scope.row.createUserName }}</span>
              </el-form-item>
              <el-form-item label="创建时间">
                <span>{{ scope.row.createTime }}</span>
              </el-form-item>
              <el-form-item label="修改人id">
                <span>{{ scope.row.updateUserId }}</span>
              </el-form-item>
              <el-form-item label="修改人">
                <span>{{ scope.row.updateUserName }}</span>
              </el-form-item>
              <el-form-item label="最后修改时间">
                <span>{{ scope.row.updateTime }}</span>
              </el-form-item>
              <el-form-item label="状态">
                <el-tag v-if="scope.row.status==='normal'" type="success">{{ scope.row.status }}</el-tag>
                <el-tag v-if="scope.row.status!=='normal'" type="danger">{{ scope.row.status }}</el-tag>
              </el-form-item>
              <el-form-item label="活动性质">
                <span>{{ scope.row.type }}</span>
              </el-form-item>
              <el-form-item label="账户余额">
                <span>{{ scope.row.account }}</span>
              </el-form-item>
              <el-form-item label="备注">
                <span>{{ scope.row.memo }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column type="index" width="40px" fixed/>
        <el-table-column prop="name" sortable="custom" label="姓名" width="100px" fixed/>
        <el-table-column prop="birthday" sortable="custom" label="生日" min-width="120px">
          <template slot-scope="scope">
            <i class="el-icon-time" style="color:red"></i>
            <span style="margin-left: 2px">{{ scope.row.birthday }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="age" sortable="custom" label="年龄" width="80px"/>
        <el-table-column prop="supper" sortable="custom" label="特级教师">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.supper" type="success">是</el-tag>
            <el-tag v-if="!scope.row.supper" type="danger">否</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="classMater" sortable="custom" label="是否班主任"/>
        <el-table-column prop="status" label="状态"/>
        <el-table-column prop="createTime" sortable="custom" label="创建时间" width="160px"/>
        <el-table-column label="操作" fixed="right" width="120px">
          <template slot-scope="scope">
            <el-button-group>
              <el-button @click="handleUpdate(scope.row)" plain icon="el-icon-edit"></el-button>
              <el-button @click="handleDelete(scope.row.id)" plain icon="el-icon-delete"></el-button>
            </el-button-group>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    <el-footer style="height: 32px;">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="query.currentPage"
        :page-sizes="[10, 20, 30, 40, 50, 100]"
        :page-size="query.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        style="padding-top: 2px"
      >
      </el-pagination>
    </el-footer>
  </el-container>

</template>

<script type="text/ecmascript-6">
  import axios from 'api/axios'
  import waves from 'directive/waves.js'// 水波纹指令
  import { NOTIFY_DURATION, MESSAGE_DURATION } from 'common/js/appconst'
  import DemoForm from './DemoForm'
  import DemoSearch from './DemoSearch'

  export default {
    components: {
      DemoForm,
      DemoSearch
    },
    directives: {
      waves
    },
    data() {
      return {
        btnLoading: false,
        loading: true,
        list: [],
        total: 0,
        query: {
          currentPage: 1,
          pageSize: 30
        },
        dialogFormVisible: false,
        searchForm: {},
        ruleForm: {},
        selectedRowIds: '',
        dialogStatus: 'update',
        maxHeight: '560',
        isShowMoreForm: false,
        isShowMoreBtn: false
      }
    },
    created() {
      this.getList()
      this.countTableHeight()
      this.windowResize()
    },
    methods: {
      getList() {
        this.loading = true
        axios.post('/demo/pagination', Object.assign({}, this.searchForm, this.query))
        .then((res) => {
          this.list = res.data.list
          this.total = Number(res.data.total)
          this.loading = false
        }).catch(() => {
          this.list = []
          this.loading = false
        })
      },
      handleSizeChange(pageSize) {
        this.query.pageSize = pageSize
        this.getList()
      },
      handleCurrentChange(currentPage) {
        this.query.currentPage = currentPage
        this.getList()
      },
      sortChange(column) {
        if (column && column.order === 'descending') {
          this.query.orderField = column.prop
          this.query.orderSort = 'desc'
        } else if (column && column.order === 'ascending') {
          this.query.orderField = column.prop
          this.query.orderSort = 'asc'
        } else {
          this.query.orderField = ''
          this.query.orderSort = ''
        }
        this.getList()
      },
      // 对数组类型的需要初始化定义为[]
      initForm() {
        this.ruleForm = {
          id: '',
          name: '',
          age: '',
          birthday: '',
          supper: false,
          classMater: 'no',
          types: [],
          status: 'normal',
          amount: '',
          memo: ''
        }
      },
      handleCreate() {
        this.initForm()
        this.dialogStatus = 'create'
        this.dialogFormVisible = true
      },
      handleUpdate(row) {
        this.initForm()
        Object.assign(this.ruleForm, row)
        if (this.ruleForm.type) {
          this.ruleForm.types = this.ruleForm.type.split(',')
        }
        this.dialogStatus = 'update'
        this.dialogFormVisible = true
      },
      handleTopUpdate() {
        if (this.multipleSelection) {
          if (this.multipleSelection.length === 1) {
            this.handleUpdate(this.multipleSelection[0])
          } else if (this.multipleSelection.length === 0) {
            this.$message.warning({
              duration: MESSAGE_DURATION,
              message: '请勾选需要编辑的记录'
            })
          } else {
            this.$message.warning({
              duration: MESSAGE_DURATION,
              message: '只能同时编辑一行'
            })
          }
        } else {
          this.$message.warning({
            duration: MESSAGE_DURATION,
            message: '请勾选需要编辑的记录'
          })
        }
      },
      handleDelete(id) {
        this.$confirm('此操作将删除记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.delete(id)
        }).catch(() => {
          this.$message.info({
            duration: MESSAGE_DURATION,
            message: '已取消删除'
          })
        })
      },
      handleBatchDelete() {
        if (this.multipleSelection && this.multipleSelection.length > 0) {
          const ids = this.multipleSelection.map((row) => row.id)
          this.selectedRowIds = ids.join(',')
          this.$confirm('此操作将删除记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.deleteIds(this.selectedRowIds)
          }).catch(() => {
            this.$message.info({
              duration: MESSAGE_DURATION,
              message: '已取消删除'
            })
          })
        } else {
          this.$message.warning({
            duration: MESSAGE_DURATION,
            message: '请勾选需要删除的记录'
          })
        }
      },
      closeDialogForm() {
        this.dialogFormVisible = false
      },
      delete(id) {
        axios.delete(`/demo/${id}`)
        .then(() => {
          this.getList()
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: NOTIFY_DURATION
          })
        }).catch(error => console.error(error))
      },
      deleteIds(id) {
        axios.delete(`/demo/ids/${id}`)
        .then(() => {
          this.getList()
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: NOTIFY_DURATION
          })
        }).catch(error => console.error(error))
      },
      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row)
          })
        } else {
          this.$refs.multipleTable.clearSelection()
        }
      },
      handleClearSearch() {
        this.searchForm = {}
        this.getList()
      },
      handleSelectionChange(val) {
        this.multipleSelection = val
      },
      windowResize() {
        window.onresize = () => {
          console.log('aaaa')
          this.countTableHeight()
          this.formMoreBtnResize()
        }
      },
      formMoreBtnResize() {
        console.log('this.$refs.searchForm.$el.clientHeight', this.$refs.searchForm.$el.clientHeight)
        if (this.$refs.searchForm.$el.clientHeight > 41) {
          this.isShowMoreBtn = true
        } else {
          this.isShowMoreBtn = false
        }
      },
      // 计算table的高度
      countTableHeight() {
        var winHeight = document.querySelector('html').clientHeight - 162
        this.maxHeight = winHeight
        this.$nextTick(() => {
          this.formMoreBtnResize()
        })
      },
      handleMoreForm() {
        this.isShowMoreForm = !this.isShowMoreForm
      }
    },
    watch: {
      isShowMoreForm() {
        this.$nextTick(() => {
          this.formMoreBtnResize()
        })
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import '~common/stylus/module'
</style>
