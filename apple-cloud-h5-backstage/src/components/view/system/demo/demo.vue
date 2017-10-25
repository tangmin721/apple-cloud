<template>
  <el-container>
    <el-header>
      <el-button-group>
        <el-button type="primary" icon="el-icon-circle-plus" @click="handleCreate">新增</el-button>
        <el-button type="primary" v-waves icon="el-icon-edit">修改</el-button>
        <el-button type="primary" icon="el-icon-delete">删除</el-button>
      </el-button-group>
      <el-dialog :title="textMap[dialogStatus]"
                 top="10vh"
                 class="my-dialog"
                 scope="scope"
                 :visible.sync="dialogFormVisible">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px"
                 class="demo-ruleForm" center>
          <el-form-item label="活动名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="活动区域" prop="region">
            <el-select :span="24" v-model="ruleForm.region" placeholder="请选择活动区域">
              <el-option label="区域一" value="shanghai"></el-option>
              <el-option label="区域二" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="活动时间" required>
            <el-col :span="24">
              <el-form-item prop="date1">
                <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1"
                                style="width: 100%;"></el-date-picker>
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item label="即时配送" prop="delivery">
            <el-switch on-text="" off-text="" v-model="ruleForm.delivery"></el-switch>
          </el-form-item>
          <el-form-item label="活动性质" prop="type">
            <el-checkbox-group v-model="ruleForm.type">
              <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
              <el-checkbox label="地推活动" name="type"></el-checkbox>
              <el-checkbox label="线下主题活动" name="type"></el-checkbox>
              <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="特殊资源" prop="resource">
            <el-radio-group v-model="ruleForm.resource">
              <el-radio label="线上品牌商赞助"></el-radio>
              <el-radio label="线下场地免费"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="活动形式" prop="desc">
            <el-input type="textarea" v-model="ruleForm.desc"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" style="border-top: 1px solid #DFE4ED">
          <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </div>
      </el-dialog>
    </el-header>
    <el-main>
      <el-table
        ref="multipleTable"
        :data="list"
        element-loading-text="给我一点时间"
        empty-text="暂无数据"
        highlight-current-row
        stripe
        @sort-change="sortChange"
        @selection-change="handleSelectionChange"
        :max-height="maxHeight"
        :height="maxHeight"
        style="width:100%;"
      >
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column type="index" width="50"/>
        <el-table-column prop="id" sortable="custom" label="Id" width="180px"/>
        <el-table-column prop="version" label="版本" width="60px"/>
        <el-table-column prop="createTime" label="创建时间" width="180px"/>
        <el-table-column prop="status" label="状态"/>
        <el-table-column prop="name" label="姓名"/>
        <el-table-column prop="birthday" label="生日">
          <template slot-scope="scope">
            <i class="el-icon-time" style="color:red"></i>
            <span style="margin-left: 2px">{{ scope.row.birthday }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="age" label="年龄"/>
        <el-table-column prop="classMater" label="是否班主任"/>
        <el-table-column prop="account" label="账户余额"/>
        <el-table-column label="操作" width="160px" fixed="right">
          <template slot-scope="scope">
            <el-button-group>
              <el-button @click="handleClick(scope.row)" type="primary" icon="el-icon-edit">
              </el-button>
              <el-button type="success" icon="el-icon-share"></el-button>
              <el-button type="danger" icon="el-icon-delete"></el-button>
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
  import {RES_OK} from 'api/config'
  import axios from 'axios'
  import waves from 'directive/waves.js'// 水波纹指令

  export default {
    directives: {
      waves
    },
    data() {
      return {
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
        ruleForm: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        textMap: {
          update: '编辑',
          create: '创建'
        },
        dialogStatus: 'update',
        formLabelWidth: '80px',
        maxHeight: '560',
        rules: {
          name: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          region: [
            {required: true, message: '请选择活动区域', trigger: 'change'}
          ],
          date1: [
            {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
          ],
          date2: [
            {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
          ],
          type: [
            {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
          ],
          resource: [
            {required: true, message: '请选择活动资源', trigger: 'change'}
          ],
          desc: [
            {required: true, message: '请填写活动形式', trigger: 'blur'}
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
        axios.post('http://localhost:9051/demo/pagination', {
          currentPage: this.query.currentPage,
          pageSize: this.query.pageSize,
          orderField: 'age',
          orderSort: 'asc'
        })
        .then((res) => {
          res = res.data
          if (res.status === RES_OK) {
            this.list = res.data.list
            this.total = res.data.total
            console.log(this.list)
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
      handleSizeChange(pageSize) {
        this.query.pageSize = pageSize
        this.getList()
      },
      handleCurrentChange(currentPage) {
        this.query.currentPage = currentPage
        this.getList()
      },
      handleCreate() {
        this.resetTemp()
        this.dialogStatus = 'create'
        this.dialogFormVisible = true
      },
      handleUpdate(row) {
        this.temp = Object.assign({}, row)
        this.dialogStatus = 'update'
        this.dialogFormVisible = true
      },
      handleDelete(row) {
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success',
          duration: 2000
        })
        const index = this.list.indexOf(row)
        this.list.splice(index, 1)
      },
      create() {
        this.temp.id = parseInt(Math.random() * 100) + 1024
        this.temp.timestamp = +new Date()
        this.temp.author = '原创作者'
        this.list.unshift(this.temp)
        this.dialogFormVisible = false
        this.$notify({
          title: '成功',
          message: '创建成功',
          type: 'success',
          duration: 2000
        })
      },
      update() {
        this.temp.timestamp = +this.temp.timestamp
        for (const v of this.list) {
          if (v.id === this.temp.id) {
            const index = this.list.indexOf(v)
            this.list.splice(index, 1, this.temp)
            break
          }
        }
        this.dialogFormVisible = false
        this.$notify({
          title: '成功',
          message: '更新成功',
          type: 'success',
          duration: 2000
        })
      },
      resetTemp() {
        this.temp = {
          id: undefined,
          importance: 0,
          remark: '',
          timestamp: 0,
          title: '',
          status: 'published',
          type: ''
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
      handleSelectionChange(val) {
        this.multipleSelection = val
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!')
          } else {
            console.log('error submit!!')
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
          console.log('cccc')
        }
      },
      // 计算table的高度
      countTableHeight() {
        var winHeight = document.querySelector('html').clientHeight - 192
        this.maxHeight = winHeight
        console.log(winHeight)
      },
      sortChange(column) {
        console.log(column)
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .el-header
    background-color: #B3C0D1;
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

  .my-dialog >>> .el-dialog .el-dialog__header
    border-bottom 1px solid #878D99
    padding-bottom 0
    .el-dialog__title
      font-weight 600


</style>
