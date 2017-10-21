<template>
  <div>
    <v-header :user="user"></v-header>
    <v-main></v-main>
  </div>
</template>

<script type="text/ecmascript-6">
  import VHeader from 'components/layout/v-header'
  import VMain from 'components/layout/v-main'
  import axios from 'axios'

  const SUCCESS = 0

  export default{
    data() {
      return {
        user: {}
      }
    },
    created() {
      axios.get('http://localhost:9051/test/2222')
      .then((res) => {
        res = res.data
        if (res.status === SUCCESS) {
          this.user = res.data
          console.log(this.user)
        }
      }).catch((error) => {
        this.$message.error({
          message: `api调用异常：${error}`,
          showClose: true
        })
      })
    },
    components: {
      VHeader,
      VMain
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
</style>
