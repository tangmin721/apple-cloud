<template>
  <div>
    <v-header :user="user"></v-header>
    <v-main></v-main>
  </div>
</template>

<script type="text/ecmascript-6">
  import VHeader from 'components/layout/v-header'
  import VMain from 'components/layout/v-main'
  import axios from 'api/axios'

  export default{
    data() {
      return {
        user: {}
      }
    },
    created() {
      axios.get('/test/2222').then(res => {
        this.user = res.data
        this.$message.success('操作成功')
      }).catch(error => error)
    },
    components: {
      VHeader,
      VMain
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
</style>
