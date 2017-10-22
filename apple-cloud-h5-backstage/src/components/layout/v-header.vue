<template>
  <div class="v-header" :class="{ hideBar: hideLeftBar }">
    <div class="log">
      <router-link to="/index/dashboard">
        <span>首页</span>
      </router-link>
    </div>
    <div class="left">
      <div class="hide-left-bar-btn">
        <i class="el-icon-tickets" :class="{ changeZ: hideLeftBar }" @click="_setHideLeftBar"></i>
      </div>
      <ul class="sso">
        <li>中台管理</li>
        <li>商家后台</li>
        <li>进销存</li>
        <li>CSM内容管理</li>
        <li>系统监控</li>
      </ul>
      <div class="search">搜索</div>
      <div class="other">
        <div class="favorite">
          <div class="message">消息</div>
          <div>待办</div>
          <div>支持</div>
          <div>帮助</div>
        </div>
        <div class="avatar-wrapper">
          <div class="avatar">
            <img :src="user.avatar" @click="logout" alt="用户头像">
            <span class="username"></span>
            <i class="el-icon-caret-bottom"></i>
          </div>
          <div class="dropdown">
          </div>
        </div>
      </div>
      <div class="screen-full">
        <i class="el-icon-rank screenfull" :class="{ changeZ: isFullscreen }" @click="_screenfull"></i>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import screenfull from 'screenfull'
  import {mapMutations, mapGetters} from 'vuex'

  export default {
    props: {
      user: {
        type: Object
      }
    },
    data() {
      return {
        isFullscreen: false
      }
    },
    computed: {
      ...mapGetters([
        'hideLeftBar'
      ])
    },
    created() {
      console.log(this.hideLeftBar)
    },
    methods: {
      _screenfull() {
        if (!screenfull.enabled) {
          this.$message({
            message: 'you browser can not work',
            type: 'warning'
          })
          return false
        }
        screenfull.toggle()
      },
      logout() {
        this.$confirm('确定要退出系统?', '提示信息', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$router.push('/login')
          this.$message({
            type: 'success',
            message: '退出成功!'
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出登录'
          })
        })
      },
      _setHideLeftBar() {
        if (this.hideLeftBar) {
          this.setHideLeftBar(false)
        } else {
          this.setHideLeftBar(true)
        }
      },
      ...mapMutations({
        setHideLeftBar: 'SET_HIDE_LEFT_BAR'
      })
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .v-header
    position relative
    height 50px;
    color $color-theme
    display flex
    &.hideBar
      .log
        flex 0 0 130px
        width 130px
    .log
      flex 0 0 180px
      width 180px
      height 50px
      transition all .3s
    .left
      display flex
      flex 1
      background rgba(155, 105, 49, 0.5)
      .hide-left-bar-btn
        width 50px
        height 50px
      .sso
        width 80px
        height 50px
        background #13ff00
      .search
        flex 1
        background #cc8602
      .other
        width 200px
        height 200px
        background #00edff
      i,.screenfull
        display inline-block
        font-size 30px
        line-height 50px
        padding 0 10px
      img
        float right
        width 50px
        height 50px
        border-radius 50%
        transition all .3s
        &:hover
          transform rotateZ(45deg)
          transition all .3s
      .changeZ
        transform rotateZ(90deg)
        transition all .3s
      .screenfull:hover
        transform scale(1.5) rotateZ(180deg)
        transition all .3s
      i
        transform rotateZ(0deg)
        transition all .3s
      .sso
        display: inline-block
</style>
