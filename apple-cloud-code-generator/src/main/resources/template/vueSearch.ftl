<template>
  <div :searchForm="searchForm">
  <#list entity.myfieldListNotTransient as e><#if e.simpleTypeName=="Boolean">
    <el-select v-model="searchForm.${e.fieldName}" placeholder="是否${e.columnComment}" size="mini" clearable style="width: 120px">
      <el-option label="是" value="true"></el-option>
      <el-option label="否" value="false"></el-option>
    </el-select>
  <#else>
    <el-input placeholder="请输入${e.columnComment}" v-model="searchForm.${e.fieldName}" style="width: 200px;margin:0 5px">
      <template slot="prepend">${e.columnComment}</template>
    </el-input>
  </#if>
  </#list>
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
