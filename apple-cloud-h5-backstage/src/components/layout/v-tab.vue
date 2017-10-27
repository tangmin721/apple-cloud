<template>
  <div class="tab">
    <!--<router-link class="tabs-view" v-for="tag in Array.from(visitedViews)" :to="tag.path" :key="tag.path">
      <el-tag :closable="true" :type="isActive(tag.path)?'primary':''" @close='closeViewTabs(tag,$event)'>
        {{tag.name}}
      </el-tag>
    </router-link>-->
    <router-link tag="div" to="/admin/dashboard" class="tab-item">
      <span class="tab-link">首页</span>
    </router-link>
    <router-link tag="div" to="/admin/userPage" class="tab-item">
      <span class="tab-link">列表</span>
    </router-link>
    <router-link tag="div" to="/admin/userForm" class="tab-item">
      <span class="tab-link">form</span>
    </router-link>
    <router-link tag="div" to="/admin/userOther" class="tab-item">
      <span class="tab-link">other</span>
    </router-link>
    <router-link tag="div" to="/admin/system/demo" class="tab-item">
       <span class="tab-link"><i class="icon-music"></i>demo 模块</span>
    </router-link>
    <router-link tag="div" to="/admin/401" class="tab-item">
       <span class="tab-link"><i class="el-icon-error"></i>401</span>
    </router-link>
    <router-link tag="div" to="/admin/404" class="tab-item">
       <span class="tab-link"><i class="el-icon-warning"></i>404</span>
    </router-link>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {

  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .tab
    display flex
    width 100%
    height 40px
    line-height 40px
    font-size $font-size-medium
    .tab-item
      flex 1
      text-align center
      background #a6c7cc
      .tab-link
        padding-bottom 5px
        color #000
      &.router-link-active
        &.tab-item
          background #0385cc
        .tab-link
          color orange
          border-bottom 2px solid $color-theme

</style>
