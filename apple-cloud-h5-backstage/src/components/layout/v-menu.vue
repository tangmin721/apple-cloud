<template>
  <div class="v-menu">
    <el-menu
      background-color="#2c2c2c"
      text-color="#d0d0d0"
      active-text-color="#ff6600"
      default-active="1-4-1"
      class="{el-menu--collapse:hideLeftBar}"
      @open="handleOpen"
      @close="handleClose"
      :collapse="hideLeftBar">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span slot="title">系统管理</span>
        </template>
        <el-menu-item-group>
          <span slot="title">分组一</span>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <span slot="title">选项4</span>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
          <el-menu-item index="1-4-3">选项3</el-menu-item>
          <el-menu-item index="1-4-4">选项4</el-menu-item>
          <el-menu-item index="1-4-5">选项5</el-menu-item>
          <el-menu-item index="1-4-6">选项6</el-menu-item>
          <el-menu-item index="1-4-7">选项7</el-menu-item>
          <el-menu-item index="1-4-8">选项8</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">导航二</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-setting"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
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
        alert('open')
        console.log(key, keyPath)
      },
      handleClose(key, keyPath) {
        alert('close')
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
