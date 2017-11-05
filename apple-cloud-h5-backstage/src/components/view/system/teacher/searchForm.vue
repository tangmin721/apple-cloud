<template>
  <div :searchForm="searchForm">
      <el-input placeholder="请输入姓名" v-model="searchForm.name" style="width: 200px;margin:0 5px">
      <template slot="prepend">姓名</template>
    </el-input>
    <el-input placeholder="请输入username描述@TODO'" v-model="searchForm.username" style="width: 200px;margin:0 5px">
      <template slot="prepend">username描述@TODO'</template>
    </el-input>
    <el-input placeholder="请输入身份证" v-model="searchForm.idCard" style="width: 200px;margin:0 5px">
      <template slot="prepend">身份证</template>
    </el-input>
    <el-input placeholder="请输入出生日期" v-model="searchForm.birthday" style="width: 200px;margin:0 5px">
      <template slot="prepend">出生日期</template>
    </el-input>
    <el-input placeholder="请输入出生时间" v-model="searchForm.birthdayTime" style="width: 200px;margin:0 5px">
      <template slot="prepend">出生时间</template>
    </el-input>
    <el-input placeholder="请输入分数" v-model="searchForm.score" style="width: 200px;margin:0 5px">
      <template slot="prepend">分数</template>
    </el-input>
    <el-input placeholder="请输入出版的书籍数量" v-model="searchForm.book" style="width: 200px;margin:0 5px">
      <template slot="prepend">出版的书籍数量</template>
    </el-input>
    <el-input placeholder="请输入数量" v-model="searchForm.num" style="width: 200px;margin:0 5px">
      <template slot="prepend">数量</template>
    </el-input>
    <el-input placeholder="请输入年龄" v-model="searchForm.age" style="width: 200px;margin:0 5px">
      <template slot="prepend">年龄</template>
    </el-input>
    <el-input placeholder="请输入是否班主任" v-model="searchForm.classMater" style="width: 200px;margin:0 5px">
      <template slot="prepend">是否班主任</template>
    </el-input>
    <el-input placeholder="请输入账户金额" v-model="searchForm.account" style="width: 200px;margin:0 5px">
      <template slot="prepend">账户金额</template>
    </el-input>
    <el-select v-model="searchForm.supper" placeholder="是否是否是特级教师" size="mini" clearable style="width: 120px">
      <el-option label="是" value="true"></el-option>
      <el-option label="否" value="false"></el-option>
    </el-select>
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
