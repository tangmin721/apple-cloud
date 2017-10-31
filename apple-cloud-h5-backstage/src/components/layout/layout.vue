<template>
  <div>
    <v-header :user="user"></v-header>
    <v-main></v-main>
  </div>
</template>

<script type="text/ecmascript-6">
  import VHeader from 'components/layout/v-header'
  import VMain from 'components/layout/v-main'
  import fetch from 'api/fetch'

  export default{
    data() {
      return {
        user: {}
      }
    },
    created() {
      this.user = fetch({
        url: '/test/2222',
        method: 'get'
      }).then(res => {
        console.log('res', res)
      })

      console.log('thisuser', this.user)
//      axios.get('http://10.16.70.72:9051/test/2222')
//      .then((res) => {
//        res = res.data
//        if (res.status === SUCCESS) {
//          this.user = res.data
//          console.log(this.user)
//        }
//      }).catch((error) => {
//        this.$message.error({
//          message: `api调用异常：${error}`,
//          showClose: true
//        })
//      })
    },
    components: {
      VHeader,
      VMain
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
</style>
