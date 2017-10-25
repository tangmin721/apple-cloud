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
        <el-menu-item v-waves index="/admin/dashboard"><i class="el-icon-location"></i><span slot="title">系统首页</span></el-menu-item>
        <el-menu-item v-waves index="/admin/userPage"><i class="el-icon-location"></i><span slot="title">用户管理</span></el-menu-item>
        <el-menu-item v-waves index="/admin/userForm"><i class="el-icon-location"></i><span slot="title">用户表单</span></el-menu-item>
        <el-submenu index="1-2">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">二级菜单</span>
          </template>
          <el-menu-item v-waves index="/admin/system/demo"><i class="icon-music"></i><span slot="title">demo模块</span></el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-info"></i>
          <span slot="title">错误页</span>
        </template>
        <el-menu-item v-waves index="/admin/401"><i class="el-icon-error"></i><span slot="title">401</span></el-menu-item>
        <el-menu-item v-waves index="/admin/404"><i class="el-icon-warning"></i><span slot="title">404</span></el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapGetters} from 'vuex'
  import waves from 'directive/waves.js'// 水波纹指令

  export default {
    directives: {
      waves
    },
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
