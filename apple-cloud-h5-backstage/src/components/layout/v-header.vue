<template>
  <div class="v-header" :class="{ hideBar: isHide }">
    <div class="icon">{{ user.id }}</div>
    <div class="left">
      <i class="el-icon-tickets" :class="{ changeZ: isHide }" @click="isHide = !isHide"></i>
      {{ user.name }}
      <i class="el-icon-rank screenfull" :class="{ changeZ: isFullscreen }" @click="_screenfull"></i>
      <img :src="user.avatar" alt="用户头像">
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import screenfull from 'screenfull'

  export default {
    props: {
      user: {
        type: Object
      }
    },
    data() {
      return {
        isFullscreen: false,
        isHide: false
      }
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
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .v-header
    position relative
    height 50px;
    color $color-theme
    background rgba(255, 205, 49, 0.5)
    display flex
    &.hideBar
      .icon
        flex 0 0 36px
        width 36px
    .icon
      flex 0 0 180px
      width 180px;
      background rgba(55, 05, 49, 0.5)
      transition all .3s
    .left
      flex 1
      background rgba(155, 105, 49, 0.5)
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
</style>
