<template>
  <div>
    <v-tab></v-tab>
    <keep-alive>
      <router-view class="content" :class="{ hideBar: hideLeftBar }"></router-view>
    </keep-alive>
  </div>
</template>

<script type="text/ecmascript-6">
  import VTab from 'components/layout/v-tab'
  import {mapGetters} from 'vuex'

  export default {
    computed: {
      ...mapGetters([
        'hideLeftBar'
      ])
    },
    components: {
      VTab
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  .content
    position absolute
    top 40px
    bottom 0
    overflow auto
    left $leftbar-width
    right 0
    transition all .3s
  .hideBar
    left $leftbar-collapse-width
</style>
