<template>
  <div>
    <v-tab></v-tab>
    <transition name="slide">
      <keep-alive>
        <router-view class="content"></router-view>
      </keep-alive>
    </transition>
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
    height 100%
</style>
