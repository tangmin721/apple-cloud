<template>
  <div class="tab tabdiv">
    <div class="prevBtn" @click="handlePrev">
      <i class="el-icon-caret-left"></i>
    </div>
    <div class="dashboard">
      <router-link tag="div" to="/system/index" class="tab-item-dashboard">
        <span class="tab-link"><i class="el-icon-date"></i>首页</span>
      </router-link>
    </div>
    <div class="width-wrap">
      <div class="ul-wrap">
        <ul class="nav_ul" ref="navUl" :style="{ marginLeft: navUlMarginLeft + 'px'}">
          <router-link tag="li" v-for="item in tabViewList" :key="item.name" :to="item.path" class="tab-item" @contextmenu.native.prevent="handleRight($event)">
            <span class="tab-link">{{ item.name }}</span>
            <i class="el-icon-circle-close-outline" @click.stop="handleCloseTab($event)"></i>
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
          <el-dropdown-item command="toCurrent">定位当前选项卡</el-dropdown-item>
          <el-dropdown-item command="closeOther" divided>关闭<span style="color: red">其他</span>选项卡</el-dropdown-item>
          <el-dropdown-item command="closeAll">关闭<span style="color: red">全部</span>选项卡</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapMutations, mapGetters} from 'vuex'
  import { APP_TABVIEWLIST_KEY } from 'common/js/appconst'

  const INDEX_NAME = '首页'
  const INDEX_PATH = '/system/index'
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
    computed: {
      ...mapGetters([
        'tabViewList'
      ])
    },
    created() {
      this.handleSession()
    },
    methods: {
      handleSession() {
        if (this.tabViewList && this.tabViewList.length === 0) {
          if (window.sessionStorage) {
            var sessionTabViews = sessionStorage.getItem(APP_TABVIEWLIST_KEY)
            if (sessionTabViews) {
              this._setTabViewList(JSON.parse(sessionTabViews))
            }
          }
        }
      },
      handlePrev() {
        // tabdiv 总宽
        let clientWidth = document.querySelector('.tabdiv').clientWidth
        // tabViews视宽
        let tabViewsWidth = clientWidth - fixedLeftWidth - fixedRightWidth

        this.navUlMarginLeft = this.navUlMarginLeft + tabViewsWidth
        if (this.navUlMarginLeft > fixedLeftWidth) {
          this.navUlMarginLeft = fixedLeftWidth
        }
      },
      handleNext() {
        // tabdiv 总宽
        let clientWidth = document.querySelector('.tabdiv').clientWidth
        // tabViews视宽
        let tabViewsWidth = clientWidth - fixedLeftWidth - fixedRightWidth

        // ul的总宽度
        let navUlTotalWidth = this.$refs.navUl.clientWidth

        if (tabViewsWidth < navUlTotalWidth) {
          // 最小左浮动宽
          var minMarginWidth = clientWidth - fixedRightWidth - navUlTotalWidth
          if (this.navUlMarginLeft > minMarginWidth) {
            this.navUlMarginLeft = this.navUlMarginLeft - tabViewsWidth
          }
        }
      },
      handleCommand(command) {
        // 定位当前
        if (command === 'toCurrent') {

        // 关闭其他
        } else if (command === 'closeOther') {
          var result = this.tabViewList.filter((item) => item.name === this.$route.name)
          this._setTabViewList(result)
        // 关闭全部
        } else {
          this._setTabViewList([])
          this.$router.push(INDEX_PATH)
        }
      },
      handleRight($event) {
        console.log($event)
        this.$message('tab页右键菜单')
      },
      handleCloseTab($event) {
        const routerName = $event.target.parentNode.childNodes[0].innerText
        var result = this.tabViewList.filter((item) => item.name !== routerName)
        this._setTabViewList(result)

        if (this.isActive(routerName)) {
          const latestView = result.slice(-1)[0]
          if (latestView) {
            this.$router.push(latestView.path)
          } else {
            this.$router.push(INDEX_PATH)
          }
        }
      },
      addViewTabs() {
        const visterRout = {
          name: this.$route.name,
          path: this.$route.path
        }
        if (this.$route.name !== INDEX_NAME) {
          let flag = true
          for (let item of this.tabViewList) {
            if (item.name === visterRout.name && item.path === visterRout.path) {
              flag = false
              break
            }
          }
          let result = []
          if (flag) {
            result = this.tabViewList.concat(visterRout)
            this._setTabViewList(result)
          }
        }
      },
      // 是否是当前激活的 注意是$route  不是$router
      isActive(name) {
        return name === this.$route.name
      },
      _setTabViewList(result) {
        if (window.sessionStorage) {
          sessionStorage.setItem(APP_TABVIEWLIST_KEY, JSON.stringify(result))
        }
        this.setTabViewList(result)
      },
      ...mapMutations({
        setTabViewList: 'SET_TAB_VIEW_LIST'
      })
    },
    watch: {
      $route() {
        this.addViewTabs()
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
          transition margin-left 0.3s
          .tab-item
            float left
            position relative
            text-align center
            padding 0 18px
            background #fafafa
            cursor: pointer
            border-right 1px solid #e7eaec
            .el-icon-circle-close-outline
              padding 4px
              display none
              position absolute
              font-size 12px
              top 0px
              right 0px
              cursor: pointer
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
    cursor: pointer
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
