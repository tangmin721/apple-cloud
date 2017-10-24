<template>
  <el-container>
    <el-header>
      <el-button-group>
        <el-button type="primary" icon="el-icon-edit">新增</el-button>
        <el-button type="primary" icon="el-icon-share">修改</el-button>
        <el-button type="primary" icon="el-icon-delete">删除</el-button>
      </el-button-group>
    </el-header>
    <el-main>
      <el-table
        ref="multipleTable"
        :data="list"
        element-loading-text="给我一点时间"
        empty-text="暂无数据"
        highlight-current-row
        stripe
        @selection-change="handleSelectionChange"
        style="width:100%;"
      >
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column type="index" width="50"/>
        <el-table-column prop="id" label="Id" width="180px"/>
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
        <el-table-column prop="supper" label="是否特教"/>
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

  export default {
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
        }
      }
    },
    created() {
      this.getList()
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
    padding 10px

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

</style>
