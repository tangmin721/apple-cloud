<template>
  <div class="tab">
    <!--<router-link class="tabs-view" v-for="tag in Array.from(visitedViews)" :to="tag.path" :key="tag.path">
      <el-tag :closable="true" :type="isActive(tag.path)?'primary':''" @close='closeViewTabs(tag,$event)'>
        {{tag.name}}
      </el-tag>
    </router-link>-->
    <div class="prevBtn" @click="handlePrev">
      <i class="el-icon-caret-left"></i>
    </div>
    <router-link tag="div" to="/admin/dashboard" class="tab-item">
      <span class="tab-link">首页</span>
    </router-link>
    <router-link tag="div" to="/admin/userPage" class="tab-item">
      <span class="tab-link">列表</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <router-link tag="div" to="/admin/userForm" class="tab-item">
      <span class="tab-link">form</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <router-link tag="div" to="/admin/userOther" class="tab-item">
      <span class="tab-link">other</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <router-link tag="div" to="/admin/system/demo" class="tab-item">
      <span class="tab-link"><i class="icon-music"></i>demo 模块</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <router-link tag="div" to="/admin/401" class="tab-item">
      <span class="tab-link"><i class="el-icon-error"></i>401</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <router-link tag="div" to="/admin/404" class="tab-item">
      <span class="tab-link"><i class="el-icon-warning"></i>404</span>
      <i class="el-icon-circle-close-outline"></i>
    </router-link>
    <div class="nextBtn" @click="handleNext">
      <i class="el-icon-caret-right"></i>
    </div>
    <div class="closeDropDown">
      <el-dropdown trigger="click" @command="handleCommand">
      <span class="el-dropdown-link" style="padding: 10px 0 10px 10px">
        关闭操作<i class="el-icon-caret-bottom el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">定位当前选项卡</el-dropdown-item>
          <el-dropdown-item command="b" divided>关闭全部选项卡</el-dropdown-item>
          <el-dropdown-item command="c">关闭全部选项卡</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    methods: {
      handlePrev() {
        this.$message('handlePrev')
      },
      handleNext() {
        this.$message('handleNext')
      },
      handleCommand(command) {
        this.$message('click on item ' + command)
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .tab
    display flex
    width 100%
    height 38px
    line-height 38px
    border-bottom 2px solid #2c2c2c
    font-size $font-size-medium
    color #999999
    .prevBtn
      width:16px;
      font-size:16px
      cursor: pointer
    .nextBtn
      width:16px;
      border-left 1px solid #e7eaec
      font-size:16px
      cursor: pointer
    .tab-item
      position relative
      flex 1
      text-align center
      background #fafafa
      border-left 1px solid #e7eaec
      .el-icon-circle-close-outline
        position absolute
        top 2px
        right 2px
        transition all .5s
      .tab-link
        padding-bottom 5px
      &.router-link-active
        &.tab-item
          background #2c2c2c
        .tab-link
          color #ff6600
          border-bottom 2px solid #ff6600
      &.router-link-active:hover
        background #232323
        .tab-link
          font-weight 600
    .tab-item:hover
      background #f2f2f2
      color #777
      .el-icon-circle-close-outline
        color #ff6600

    .el-icon-circle-close-outline:hover
      transform rotateZ(180deg)
      transition all .5s
    .closeDropDown
      width 85px
      border-left 1px solid #e7eaec
      .el-dropdown-link
        cursor: pointer;
      .el-icon-arrow-down
        font-size: 12px;

</style>
