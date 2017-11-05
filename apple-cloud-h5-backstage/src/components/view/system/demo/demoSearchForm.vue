<template>
  <div :searchForm="searchForm">
    <el-select v-model="searchForm.status" placeholder="状态" clearable style="width: 120px">
      <el-option label="无效" value="invalid"></el-option>
      <el-option label="正常" value="normal"></el-option>
      <el-option label="删除" value="deleted"></el-option>
      <el-option label="禁用" value="disabled"></el-option>
      <el-option label="冻结" value="frozen"></el-option>
    </el-select>
    <el-input v-for="item in 3" placeholder="请输入内容" v-model="searchForm.name" style="width: 200px;margin:0 5px">
      <template slot="prepend">姓名</template>
    </el-input>
  </div>
</template>

<script type="text/ecmascript-6">
  export default{
    props: {
      searchForm: Object
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
