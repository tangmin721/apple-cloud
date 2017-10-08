<template>
  <div id="app">
    <layout></layout>
  </div>
</template>

<script type="text/ecmascript-6">
  import Layout from 'components/layout/layout'

  export default{
    components: {
      Layout
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/variable"

  #app
    color: $color-theme
</style>
