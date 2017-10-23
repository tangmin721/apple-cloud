<template>
  <div class="v-header">
    <div class="header_box">
      <img src="./logo.png" alt="" class="logo"/>
      <ul class="list">
        <li>首页</li>
        <li>直播</li>
        <li>分类</li>
      </ul>
      <div
          :class="{
          search:!inputActive,
          searchActive:inputActive
        }"
      >
        <input
        type="search"
        :placeholder="inputActive?'search':'hahaha---'"
        @focus="userFocus(true)"
        @blur="userFocus(false)"
         />
      </div>
      <div class="user">
        <div class="user_content">
          <img src="./log.png" alt=""/>
          <span>12345</span>
        </div>
        <div class="user_dropdown">
          <b class="arrow_top"></b>
          213435678
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
        isFullscreen: false,
        inputActive: false
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
      userFocus(type) {
        this.inputActive = type
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
  .v-header
    background #373237
    position absolute
    width 100%
    height 50px
  .header_box
    position relative
    top 0
    z-index 2
  .logo
    margin-top 8px
    position absolute
    width 87px
    height 35px
    left 0
    top 0
  .v-header:before
    content: ''
    position: absolute
    left: 0
    top: 0
    width: 420px
    height: 100%
    background: url(../../common/image/left_bg.jpg) no-repeat
  .v-header:after
    content ''
    position absolute
    right 0
    top 0
    width 420px
    height: 100%
    background url(../../common/image/right_bg.jpg) no-repeat
  .list
    overflow hidden
    height 100%
    margin-left 180px
  .list li
    color #d0d0d0
    font-size 20px
    float left
    line-height 50px
    width 63px
    text-align center
  .list li:hover
    color #ff6600
  .searchActive,
  .search,
  .user,
  .screen-full
    position absolute
    top 0
  .search,
  .searchActive
    background #585158
    right 200px
    width 136px
    height 30px
    margin-top 10px
    border-radius 80px
    transition all 500ms
  .searchActive
    width 170px
  .searchActive input,
  .search input
    height 100%
    width 100%
    display block
    border none
    outline none
    background transparent
    padding-left 10px
    color #d0d0d0
    line-height 30px
  .user
    right 10px
    width 160px
    height 30px
    margin-top 10px
  // background red
    .user_content
      img
        width 30px
        height 30px
        box-sizing border-box
        border-radius 50%
        border 1px solid yellow
        vertical-align middle
      span
        font-size 16px
        color #ccc
    .user_dropdown
      height 0
      transform scale(0)
      position absolute
      right 10px
      top 40px
      width 240px
      height 300px
      border 1px solid #ddd
      box-shadow 0 0 2px rgba(255,255,255,0.3)
      border-radius 3px
      padding 10px
      background #fff
      transition all cubic-bezier(.22,.58,.12,.98) .5s;
      transform-origin 50% 0
      .arrow_top
        border 6px solid transparent
        border-bottom 6px solid #fff
        position absolute
        top -12px
        left 120px
        width 0
        height 0
  .user:hover .user_dropdown
    transform scale(1)
  .screen-full
    right 10px
    color #d0d0d0
    font-size 20px
    line-height 50px
    transition all 300ms
  .screen-full:hover
    transform scale(1.5) rotateZ(180deg)
    color #ff6600
</style>
