<template>
  <el-container>
    <el-header header-align="left">
      <div class="header-wrap">
        <div class="btn-group">
          <el-button-group>
            <el-button type="primary" icon="el-icon-circle-plus" @click="handleCreate">新增</el-button>
            <el-button v-waves type="success" icon="el-icon-edit" @click="handleTopUpdate">修改</el-button>
            <el-button v-waves type="danger" icon="el-icon-delete" @click="handleBatchDelete">删除</el-button>
          </el-button-group>
        </div>
        <div class="search-form">
          <el-form :inline="true" :model="searchForm" class="demo-form-inline" align="left">
            <el-form-item label="姓名">
              <el-input v-model.trim="searchForm.name" placeholder="姓名" :required="true" style="width: 100px"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model.number="searchForm.age" placeholder="年龄" required="number" style="width: 100px"></el-input>
            </el-form-item>
            <el-form-item label="状态">
              <el-select v-model="searchForm.status" placeholder="状态" style="width: 120px">
                <el-option label="无效" value="invalid"></el-option>
                <el-option label="正常" value="normal"></el-option>
                <el-option label="删除" value="deleted"></el-option>
                <el-option label="禁用" value="disabled"></el-option>
                <el-option label="冻结" value="frozen"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button-group>
                <el-button v-waves type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button v-waves type="warning" icon="el-icon-delete" @click="handleClearSearch">清空</el-button>
              </el-button-group>
            </el-form-item>
          </el-form>
        </div>
      </div>

      <el-dialog :title="textMap[dialogStatus]"
                 top="10vh"
                 class="my-dialog"
                 scope="scope"
                 :visible.sync="dialogFormVisible">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" align="left"
                 class="demo-ruleForm" center>
          <el-form-item label="姓名" prop="name">
            <el-input prefix-icon="el-icon-service" style="width: 200px"
                      v-model.trim="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input-number v-model="ruleForm.age" :min="18" :max="60"
                             style="width: 100px"></el-input-number>
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-select v-model="ruleForm.status" disabled placeholder="请选择状态" style="width: 200px">
              <el-option label="无效" value="invalid"></el-option>
              <el-option label="正常" value="normal"></el-option>
              <el-option label="删除" value="deleted"></el-option>
              <el-option label="禁用" value="disabled"></el-option>
              <el-option label="冻结" value="frozen"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="生日" prop="birthday">
            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthday"
                            format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                            style="width: 200px"></el-date-picker>
          </el-form-item>
          <el-form-item label="特级教师" prop="supper">
            <el-switch on-text="" off-text="" v-model="ruleForm.supper"></el-switch>
          </el-form-item>
          <el-form-item label="活动性质" prop="types">
            <el-checkbox-group v-model="ruleForm.types" @change="handleTypeChange">
              <el-checkbox label="美食线上活动" name="types"></el-checkbox>
              <el-checkbox label="地推活动" name="types"></el-checkbox>
              <el-checkbox label="线下主题活动" name="types"></el-checkbox>
              <el-checkbox label="单纯品牌曝光" name="types"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="班主任" prop="classMater">
            <el-radio-group v-model="ruleForm.classMater">
              <el-radio label="yes">是</el-radio>
              <el-radio label="no">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="账户余额" prop="account">
            <el-input prefix-icon="el-icon-service" style="width: 200px"
                      v-model.number="ruleForm.account"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="memo">
            <el-input type="textarea" v-model="ruleForm.memo"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button icon="el-icon-success" type="primary" @click="submitForm('ruleForm')">确 定</el-button>
          <el-button icon="icon-add" @click="resetForm('ruleForm')"> 重 置</el-button>
          <el-button icon="icon-music" @click="dialogFormVisible = false"> 取 消</el-button>
        </div>
      </el-dialog>
    </el-header>
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
        <el-table-column type="selection" width="14px"/>
        <el-table-column width="20px" align="center" type="expand">
          <template slot-scope="scope">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="id" sortable="custom" >
                <span>{{ scope.row.id }}</span>
              </el-form-item>
              <el-form-item label="版本号" width="200px">
                <span>{{ scope.row.version }}</span>
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
        <el-table-column type="index" width="50"/>
        <el-table-column prop="createTime" sortable="custom" label="创建时间" width="160px"/>
        <el-table-column prop="name" sortable="custom" label="姓名"/>
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
        <el-table-column label="操作" fixed="right" width="120px">
          <template slot-scope="scope">
            <el-button-group>
              <el-button @click="handleUpdate(scope.row)" type="success" icon="el-icon-edit"/>
              <el-button type="danger" icon="el-icon-delete" @click="handleDelete(scope.row.id)"/>
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
  import {RES_OK, RES_EMPTY} from 'api/config'
  import axios from 'axios'
  import waves from 'directive/waves.js'// 水波纹指令

  export default {
    directives: {
      waves
    },
    data() {
      return {
        loading: true,
        list: [],
        currentPage: 1,
        pageSize: 10,
        pageCount: 1,
        total: 0,
        query: {
          currentPage: 1,
          pageSize: 30,
          orderField: '',
          orderSort: ''
        },
        dialogFormVisible: false,
        searchForm: {
          id: '',
          name: '',
          age: '',
          birthday: '',
          classMater: 'yes',
          type: '',
          types: [],
          status: '',
          supper: false,
          account: 0
        },
        ruleForm: {
          id: '',
          name: '',
          age: 18,
          birthday: '',
          classMater: 'yes',
          type: '',
          types: [],
          status: '',
          supper: false,
          account: 0
        },
        textMap: {
          update: '编辑',
          create: '创建'
        },
        selectedRowIds: '',
        dialogStatus: 'update',
        formLabelWidth: '80px',
        maxHeight: '560',
        rules: {
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 2, max: 32, message: '长度在 2 到 32 个字符', trigger: 'blur'}
          ],
          birthday: [
            {required: true, message: '请选择日期', trigger: 'change'}
          ],
          status: [
            {required: true, message: '请选择状态', trigger: 'change'}
          ],
          types: [
            {type: 'array', required: true, message: '请至少选择一个', trigger: 'change'}
          ],
          account: [
            {required: true, message: '请输入账户余额'},
            {type: 'number', message: '余额必须为数字'}
          ],
          memo: [
            {required: true, message: '请填写备注', trigger: 'blur'}
          ]
        }
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
       // setTimeout(() => {
        axios.post('http://localhost:9051/demo/pagination', {
          name: this.searchForm.name,
          age: this.searchForm.age,
          status: this.searchForm.status,
          currentPage: this.query.currentPage,
          pageSize: this.query.pageSize,
          orderField: this.query.orderField,
          orderSort: this.query.orderSort
        })
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            this.list = res.data.list
            this.total = Number(res.data.total)
          } else if (res.status === RES_EMPTY) {
            this.list = []
          } else {
            this.$message.error({
              message: `api调用异常：${res.message}`,
              showClose: true
            })
          }
          this.loading = false
        }).catch((error) => {
          this.loading = false
          this.$message.error({
            message: `api调用异常：${error}`,
            showClose: true
          })
        })
       // }, 3000)
      },
      handleSizeChange(pageSize) {
        this.query.pageSize = pageSize
        this.getList()
      },
      handleCurrentChange(currentPage) {
        this.query.currentPage = currentPage
        this.getList()
      },
      handleCreate() {
        this.resetRuleForm()
        this.dialogStatus = 'create'
        this.dialogFormVisible = true
      },
      handleUpdate(row) {
        this.resetRuleForm()
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
              duration: 1000,
              message: '请勾选需要编辑的记录'
            })
          } else {
            this.$message.warning({
              duration: 1000,
              message: '只能同时编辑一行'
            })
          }
        } else {
          this.$message.warning({
            duration: 1000,
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
            duration: 1000,
            message: '已取消删除'
          })
        })
      },
      handleBatchDelete() {
        if (this.multipleSelection && this.multipleSelection.length > 0) {
          const ids = this.multipleSelection.map((row) => row.id)
          console.log('ids', ids)
          this.selectedRowIds = ids.join(',')
          this.$confirm('此操作将删除记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.deleteIds(this.selectedRowIds)
          }).catch(() => {
            this.$message.info({
              duration: 1000,
              message: '已取消删除'
            })
          })
        } else {
          this.$message.warning({
            duration: 1000,
            message: '请勾选需要删除的记录'
          })
        }
      },
      create() {
        axios.post('http://localhost:9051/demo', this.ruleForm)
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            console.log(this.list)
            this.getList()
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '创建成功',
              type: 'success',
              duration: 2000
            })
          } else {
            this.$message.error({
              message: `api调用异常：${res.message}`,
              showClose: true
            })
          }
        }).catch((error) => {
          this.$message.error({
            message: `api调用异常：${error}`,
            showClose: true
          })
        })
      },
      update() {
        axios.put('http://localhost:9051/demo', this.ruleForm)
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            this.getList()
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '更新成功',
              type: 'success',
              duration: 2000
            })
          } else {
            this.$message.error({
              message: `api调用异常：${res.message}`,
              showClose: true
            })
          }
        }).catch((error) => {
          this.$message.error({
            message: `api调用异常：${error}`,
            showClose: true
          })
        })
      },
      delete(id) {
        axios.delete(`http://localhost:9051/demo/${id}`)
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            this.getList()
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            })
          } else {
            this.$message.error({
              message: `api调用异常：${res.message}`,
              showClose: true
            })
          }
        }).catch((error) => {
          this.$message.error({
            message: `api调用异常：${error}`,
            showClose: true
          })
        })
      },
      deleteIds(id) {
        axios.delete(`http://localhost:9051/demo/ids/${id}`)
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            this.getList()
            this.$notify({
              title: '成功',
              message: '删除成功',
              type: 'success',
              duration: 2000
            })
          } else {
            this.$message.error({
              message: `api调用异常：${res.message}`,
              showClose: true
            })
          }
        }).catch((error) => {
          this.$message.error({
            message: `api调用异常：${error}`,
            showClose: true
          })
        })
      },
      resetRuleForm() {
        this.ruleForm = {
          id: '',
          name: '',
          age: 18,
          birthday: '',
          classMater: 'yes',
          type: '',
          types: [],
          status: 'normal',
          supper: false,
          account: 0,
          memo: ''
        }
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
      handleSearch() {
        this.getList()
      },
      handleClearSearch() {
        this.searchForm = {
          id: '',
          name: '',
          age: '',
          birthday: '',
          classMater: 'yes',
          type: '',
          types: [],
          status: '',
          supper: false,
          account: 0
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val
      },
      handleTypeChange() {
        this.ruleForm.type = this.ruleForm.types.join(',')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.ruleForm.id) {
              this.update()
            } else {
              this.create()
            }
          } else {
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      },
      windowResize() {
        window.onresize = () => {
          this.countTableHeight()
        }
      },
      // 计算table的高度
      countTableHeight() {
        var winHeight = document.querySelector('html').clientHeight - 192
        this.maxHeight = winHeight
      },
      sortChange(column) {
        console.log(column)
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
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .header-wrap
    display flex
    .btn-group
      width 300px
    .search-form
      flex 1
      height 60px
      line-height 60px
    .search-form >>> .el-form
      .el-form-item.el-form-item--mini
        height 44px
        padding 16px 0 0 0
        margin 0
        .el-form-item__label
          height 28px
          vertical-align top
  .el-header
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 60px;

  .el-main
    background-color: #E9EEF3;
    color: #333;
    padding 5px

  .el-footer
    background-color: #EDF2FC;
    color: #333;
    line-height: 30px;
    height 30px

  .el-pagination
    padding 1px 0
    line-height: 30px;
    margin 0 auto
    padding 0
    text-align: center;

  .demo-table-expand
    font-size: 0;
  .demo-table-expand >>> label
    width: 90px;
    color: #99a9bf;
  .demo-table-expand >>> .el-form-item
    margin-right: 0;
    margin-bottom: 0;
    width: 33.3%;

  .my-dialog >>> .el-dialog
    .el-dialog__header
      border-bottom 1px solid #DFE4ED
      padding-bottom 0
      .el-dialog__title
        font-weight 600
    .el-dialog__footer
      border-top 1px solid #DFE4ED
      padding 0 10px

</style>
