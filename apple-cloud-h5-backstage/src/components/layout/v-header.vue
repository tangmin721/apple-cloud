<template>
  <div class="v-header" :class="{isHide}">
    <div class="icon">{{user.id}}</div>
    <div class="left">
      <i class="el-icon-more" @click="isHide = !isHide"></i>
      {{user.name}}
      <img :src="user.avatar" alt="用户头像">
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    props: {
      user: {
        type: Object
      }
    },
    data() {
      return {
        isHide: false
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
      transition all .2s
    .left
      line-height inherit
      flex 1
      background rgba(155, 105, 49, 0.5)
      img
        float right
        width 50px
        height 50px
        border-radius 50%
      i
        display inline-block
        vertical-align top
        margin-top 6px
        width 30px
        height 32px
        margin-right 9px
</style>
