<template>
  <div>
    <v-tab></v-tab>
    <keep-alive>
      <router-view class="content"></router-view>
    </keep-alive>
  </div>
</template>

<script type="text/ecmascript-6">
  import VTab from 'components/layout/v-tab'
  export default {
    components: {
      VTab
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .content
    position absolute
    top 40px
    bottom 0
    overflow auto
</style>
