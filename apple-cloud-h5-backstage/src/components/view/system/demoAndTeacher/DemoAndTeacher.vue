<template>
  <div class="demo-and-teacher">
    <demo class="demo"></demo>
    <teacher class="teacher"></teacher>
  </div>
</template>

<script type="text/ecmascript-6">
  import Demo from '../demo/Demo'
  import Teacher from '../teacher/Teacher'
  export default{
    components: {
      Demo,
      Teacher
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .demo-and-teacher
    display flex
    .demo
      display 1
    .teacher
      display 1

</style>
