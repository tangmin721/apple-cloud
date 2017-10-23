<template xmlns="http://www.w3.org/1999/html">
  <div class="login-wrap">
    <h1>登录首页</h1>
    <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="100px"
             size="medium"
             class="login">

      <el-form-item label="用户名" prop="username">
        <el-input v-model="loginForm.username"
                  placeholder="请输入用户名"
                  prefix-icon="el-icon-service"></el-input>
      </el-form-item>
      <el-form-item label="密 码" prop="password">
        <el-input type="password" v-model="loginForm.password"
                  placeholder="请输入密码"
                  prefix-icon="el-icon-view"></el-input>
      </el-form-item>
      <el-form-item label="记住我" prop="delivery">
        <el-switch v-model="loginForm.rememberme"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
        <el-button @click="resetForm('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script type="text/ecmascript-6">
  export default {
    data() {
      return {
        loginForm: {
          username: '',
          password: '',
          rememberme: false
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {min: 5, max: 32, message: '长度在 5 到 32 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push('/index')
            this.$message({
              type: 'success',
              message: '登录成功!'
            })
          } else {
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .login-wrap
    margin 100px auto
    width 400px
    background rgba(0, 0, 0, 0.05)
    h1
      text-align center
      padding 20px
      font-size 1.5em
      font-weight 700
      color #000
    .login
      padding-right 50px
      padding-bottom 20px

</style>
