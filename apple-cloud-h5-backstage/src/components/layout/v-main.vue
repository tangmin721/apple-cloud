<template>
  <div class="v-main">
    <div class="menu-wrapper">menu</div>
    <div class="content-wrapper">
      <tab></tab>
      <transition name="slide">
        <keep-alive>
          <router-view ></router-view>
        </keep-alive>
      </transition>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import Tab from 'components/layout/tab'
  export default {
    components: {
      Tab
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .v-main
    display flex
    position absolute
    top 50px
    bottom 46px
    width 100%
    background rgba(125, 215, 49, 0.5)
    overflow hidden
    .menu-wrapper
      flex 0 0 180px
      width 180px
      background #ff5c4f
    .content-wrapper
      flex 1
      background #ce5fff


</style>
