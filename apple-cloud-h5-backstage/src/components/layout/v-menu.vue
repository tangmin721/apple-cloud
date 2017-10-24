<template>
  <div class="v-menu">
    <el-menu
      background-color="#2c2c2c"
      text-color="#d0d0d0"
      style="border:none"
      active-text-color="#ff6600"
      default-active="1-4-1"
      class="{el-menu--collapse:hideLeftBar}"
      @open="handleOpen"
      @close="handleClose"
      :default-active="$route.path"
      :collapse="hideLeftBar" router>
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span slot="title">系统管理</span>
        </template>
        <el-menu-item index="1-1">选项1</el-menu-item>
        <el-menu-item index="1-2">选项2</el-menu-item>
        <el-submenu index="1-4">
          <span slot="title">选项4</span>
          <el-menu-item index="/index/userPage">用户首页</el-menu-item>
          <el-menu-item index="/index/userForm">userForm</el-menu-item>
          <el-menu-item index="/index/dashboard">dashboard</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu>
        <template slot="title">
          <i class="icon-music"></i>
          <span slot="title">错误页</span>
        </template>
        <el-menu-item index="1-1">选项1</el-menu-item>
        <el-menu-item index="1-2">选项2</el-menu-item>
        <el-submenu index="1-4">
          <span slot="title">选项4</span>
          <el-menu-item index="/index/userPage">用户首页</el-menu-item>
          <el-menu-item index="/index/userForm">userForm</el-menu-item>
          <el-menu-item index="/index/dashboard">dashboard</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapGetters} from 'vuex'

  export default {
    computed: {
      ...mapGetters([
        'hideLeftBar'
      ])
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath)
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .el-menu-vertical-demo:not(.el-menu--collapse)
    width: 200px;
    min-height: 400px;
  .el-submenu .el-menu-item
    min-width 180px
  .el-submenu__title
    padding-left 5px
</style>
