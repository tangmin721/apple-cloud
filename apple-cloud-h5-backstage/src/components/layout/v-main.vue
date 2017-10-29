<template>
  <div class="v-main" :class="{ hideBar: hideLeftBar }">
    <v-menu class="menu-wrapper"></v-menu>
    <v-content class="content-wrapper"></v-content>
  </div>
</template>

<script type="text/ecmascript-6">
  import VMenu from 'components/layout/v-menu'
  import VContent from 'components/layout/v-content'
  import {mapGetters} from 'vuex'

  export default {
    computed: {
      ...mapGetters([
        'hideLeftBar'
      ])
    },
    components: {
      VMenu,
      VContent
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .v-main
    display flex
    position absolute
    top 50px
    bottom 0
    width 100%
    overflow hidden
    &.hideBar
      .menu-wrapper
        flex 0 0 $leftbar-collapse-width
        width $leftbar-collapse-width
        background #2c2c2c
        transition all .3s
    .menu-wrapper
      z-index 5
      flex 0 0 $leftbar-width
      width $leftbar-width
      background #2c2c2c
      transition all .3s
      overflow-y: auto;
      &::-webkit-scrollbar
        display:none
    .content-wrapper
      flex 1

</style>
