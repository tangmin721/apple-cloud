<template>
  <div class="errPage-container">
    <el-button @click="back" icon='arrow-left' class="pan-back-btn" size="large">返回</el-button>
    <el-row>
      <el-col :span="12">
        <h1 class="text-jumbo text-ginormous">Oops!</h1>
        <h2>你没有权限去该页面</h2>
        <h3>如有不满请联系你领导</h3>
        <h4>或者你可以去:</h4>
        <ul class="list-unstyled">
          <li class="link-type">
            <router-link to="/index/dashboard">回首页</router-link>
          </li>
          <li><a @click.prevent="dialogVisible=true" href="#">点我看图</a></li>
        </ul>
      </el-col>
      <el-col :span="12">
        <img :src="errGif" width="313" height="428" alt="Girl has dropped her ice cream.">
      </el-col>
    </el-row>
    <el-dialog title="随便看" :visible.sync="dialogVisible" size="large">
      <img class="pan-img" :src="ewizardClap">
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import errGif from 'components/error/401.gif'

  export default {
    data() {
      return {
        errGif: errGif,
        ewizardClap: errGif,
        dialogVisible: false
      }
    },
    methods: {
      back() {
        if (this.$route.query.noGoBack) {
          this.$router.push({ path: '/dashboard' })
        } else {
          this.$router.go(-1)
        }
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .errPage-container
    width 800px
    margin 100px auto
    .pan-back-btn
      background #008489
      color #fff
    .pan-gif
      margin 0 auto
      display block
    .pan-img
      display block
      margin 0 auto
    .text-jumbo
      font-size 60px
      font-weight 700
      color #484848
      padding 40px 0
    h2
      padding 20px 0
      font-size 1.5em
      font-weight 700
      color #000
    h3
      padding 20px 0
      font-size 1.1em
      font-weight 600
      color #000
    h4
      padding 20px 0
      font-size 1em
      font-weight 700
      color #000
    .list-unstyled
      font-size 14px
      padding-left 2em
      li
        padding-bottom 5px
        list-style-type square
      a
        color #008489
        text-decoration none
        &:hover
          text-decoration underline

</style>
