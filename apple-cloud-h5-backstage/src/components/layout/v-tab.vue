<template>
  <div class="tab tabdiv">
    <!--<router-link class="tabs-view" v-for="tag in Array.from(visitedViews)" :to="tag.path" :key="tag.path">
      <el-tag :closable="true" :type="isActive(tag.path)?'primary':''" @close='closeViewTabs(tag,$event)'>
        {{tag.name}}
      </el-tag>
    </router-link>-->
    <div class="prevBtn" @click="handlePrev">
      <i class="el-icon-caret-left"></i>
    </div>
    <div class="dashboard">
      <router-link tag="div" to="/admin/dashboard" class="tab-item-dashboard">
        <span class="tab-link"><i class="el-icon-date"></i>首页</span>
      </router-link>
    </div>
    <div class="width-wrap">
      <div class="ul-wrap">
        <ul class="nav_ul" ref="navUl" :style="{ marginLeft: navUlMarginLeft + 'px'}">
          <router-link tag="li" to="/admin/userPage" class="tab-item">
            <span class="tab-link">列表</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
          <router-link tag="li" to="/admin/userForm" class="tab-item">
            <span class="tab-link">form</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
          <router-link tag="li" to="/admin/userOther" class="tab-item">
            <span class="tab-link">other</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
          <router-link tag="li" to="/admin/system/demo" class="tab-item">
            <span class="tab-link"><i class="icon-music"></i>demo 模块</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
          <router-link tag="li" to="/admin/401" class="tab-item">
            <span class="tab-link"><i class="el-icon-error"></i>401</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
          <router-link tag="li" to="/admin/404" class="tab-item" v-for="n in 50">
            <span class="tab-link"><i class="el-icon-warning"></i>{{ n }}</span>
            <i class="el-icon-circle-close-outline"></i>
          </router-link>
        </ul>
      </div>
    </div>
    <div class="nextBtn" @click="handleNext">
      <i class="el-icon-caret-right"></i>
    </div>
    <div class="closeDropDown">
      <el-dropdown @command="handleCommand" size="small">
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
  // 上一步,首页的固定宽度
  const fixedLeftWidth = 96

  // 上一步,首页的固定宽度
  const fixedRightWidth = 101

  export default {
    data() {
      return {
        navUlMarginLeft: fixedLeftWidth
      }
    },
    methods: {
      handlePrev() {
        // tabdiv 总宽
        let clientWidth = document.querySelector('.tabdiv').clientWidth
        console.log('clientWidth', clientWidth)

        // tabViews视宽
        let tabViewsWidth = clientWidth - fixedLeftWidth - fixedRightWidth

        this.navUlMarginLeft = this.navUlMarginLeft + tabViewsWidth
        console.log('handleNext', this.navUlMarginLeft)
        if (this.navUlMarginLeft > fixedLeftWidth) {
          this.navUlMarginLeft = fixedLeftWidth
        }
        console.log('handleNext', this.navUlMarginLeft)
      },
      handleNext() {
        // tabdiv 总宽
        let clientWidth = document.querySelector('.tabdiv').clientWidth
        console.log('clientWidth', clientWidth)

        // tabViews视宽
        let tabViewsWidth = clientWidth - fixedLeftWidth - fixedRightWidth

        // ul的总宽度
        let navUlTotalWidth = this.$refs.navUl.clientWidth

        if (tabViewsWidth < navUlTotalWidth) {
          // 最小左浮动宽
          var minMarginWidth = clientWidth - fixedRightWidth - navUlTotalWidth
          console.log('minMarginWidth', minMarginWidth)
          if (this.navUlMarginLeft > minMarginWidth) {
            this.navUlMarginLeft = this.navUlMarginLeft - tabViewsWidth
          }
        }
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
    position relative
    width 100%
    height 38px
    line-height 38px
    border-bottom 2px solid #2c2c2c
    font-size $font-size-medium
    color #999999
    .prevBtn
      position absolute
      z-index: 9
      left 0
      top: 0
      width:16px;
      font-size:16px
      cursor: pointer
      background #fafafa
      &:hover
        color: #232323
    .dashboard
      position absolute
      z-index: 9
      left 16px
      top: 0
      width 80px
    .nextBtn
      position absolute
      top 0
      right 85px
      width:16px;
      border-left 1px solid #e7eaec
      font-size:16px
      cursor: pointer
      background #fafafa
      &:hover
        color: #232323
    .width-wrap
      width 0
      .ul-wrap
        width 10000px
        .nav_ul
          float left
          height 38px
          .tab-item
            float left
            position relative
            text-align center
            padding 0 18px
            background #fafafa
            border-right 1px solid #e7eaec
            .el-icon-circle-close-outline
              display none
              position absolute
              font-size 12px
              top 2px
              right 2px
              transition all .3s
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
              .el-icon-circle-close-outline
                color #ff6600
          .tab-item:hover
            background #f2f2f2
            color #777
            .el-icon-circle-close-outline
              display block
              color #2c2c2c


    .el-icon-circle-close-outline:hover
      transform rotateZ(180deg)
      transition all .3s
    .closeDropDown
      position absolute
      z-index: 9
      right 0
      top 0
      width 85px
      border-left 1px solid #e7eaec
      background #fafafa
      &:hover
        background #f2f2f2
      .el-dropdown-link
        cursor: pointer;
      .el-icon-arrow-down
        font-size: 12px;

  .tab-item-dashboard
    text-align center
    background #fafafa
    border-left 1px solid #e7eaec
    border-right 1px solid #e7eaec
    .tab-link
      padding-bottom 5px
    &.router-link-active
      &.tab-item-dashboard
        background #2c2c2c
      .tab-link
        color #ff6600
        border-bottom 2px solid #ff6600
    &.router-link-active:hover
      background #232323
  .tab-item-dashboard:hover
    background #f2f2f2
    color #777
</style>
