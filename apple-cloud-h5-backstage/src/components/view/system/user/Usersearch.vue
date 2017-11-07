<template>
  <div :searchForm="searchForm">
      <el-input placeholder="请输入用户名" v-model="searchForm.username" style="width: 200px;margin:0 5px">
      <template slot="prepend">用户名</template>
    </el-input>
    <el-input placeholder="请输入密码" v-model="searchForm.password" style="width: 200px;margin:0 5px">
      <template slot="prepend">密码</template>
    </el-input>
    <el-input placeholder="请输入手机" v-model="searchForm.mobile" style="width: 200px;margin:0 5px">
      <template slot="prepend">手机</template>
    </el-input>
    <el-input placeholder="请输入Email" v-model="searchForm.email" style="width: 200px;margin:0 5px">
      <template slot="prepend">Email</template>
    </el-input>
    <el-input placeholder="请输入头像" v-model="searchForm.avatar" style="width: 200px;margin:0 5px">
      <template slot="prepend">头像</template>
    </el-input>
    <el-select v-model="searchForm.status" placeholder="状态" size="mini" clearable style="width: 120px">
      <el-option label="无效" value="invalid"></el-option>
      <el-option label="正常" value="normal"></el-option>
      <el-option label="删除" value="deleted"></el-option>
      <el-option label="禁用" value="disabled"></el-option>
      <el-option label="冻结" value="frozen"></el-option>
    </el-select>
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
