<template>
  <div class="v-menu" :class="{ hideBar: isHide }">menu2
    <div class="hideBtn">
      <i class="el-icon-tickets" :class="{ changeZ: isHide }" @click="isHide = !isHide"></i>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default{
    data() {
      return {
        isFullscreen: false,
        isHide: false
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
