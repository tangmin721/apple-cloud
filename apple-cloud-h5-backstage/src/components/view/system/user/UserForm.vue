<template>
  <el-dialog :title="textMap[dialogStatus]"
             top="91px"
             class="my-dialog"
             scope="scope"
             :dialogStatus="dialogStatus"
             :dialogFormVisible="dialogFormVisible"
             :ruleForm="ruleForm"
             :before-close="closeDialogForm"
             :visible="dialogFormVisible">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="160px" align="left"
             class="module-ruleForm" center v-if="dialogFormVisible">
      <el-form-item label="用户名" prop="username">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.username"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.password"
        ></el-input>
      </el-form-item>
      <el-form-item label="手机" prop="mobile">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.mobile"
        ></el-input>
      </el-form-item>
      <el-form-item label="Email" prop="email">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.email"
        ></el-input>
      </el-form-item>
      <el-form-item label="头像" prop="avatar">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.avatar"
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button icon="el-icon-success" type="primary" @click="submitForm('ruleForm')" :loading="btnLoading">确 定</el-button>
      <el-button-group>
        <el-button icon="el-icon-refresh" @click="resetForm('ruleForm')">重 置</el-button>
        <el-button icon="el-icon-circle-close" @click="closeDialogForm">取 消</el-button>
      </el-button-group>
    </div>
  </el-dialog>
</template>

<script type="text/ecmascript-6">
  import axios from 'api/axios'

  export default{
    props: {
      dialogFormVisible: Boolean,
      dialogStatus: String,
      ruleForm: Object
    },
    data() {
      return {
        btnLoading: false,
        textMap: {
          update: '编辑',
          create: '创建'
        },
        rules: {
          username: [
            {required: true, message: '请填写用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请填写密码', trigger: 'blur'}
          ],
          mobile: [
            {required: true, message: '请填写手机', trigger: 'blur'}
          ],
          email: [
            {required: true, message: '请填写Email', trigger: 'blur'}
          ],
          avatar: [
            {required: true, message: '请填写头像', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.btnLoading = true
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.ruleForm.id) {
              this.update()
            } else {
              this.create()
            }
          } else {
            this.btnLoading = false
            return false
          }
        })
      },
      create() {
        axios.post('/user', this.ruleForm)
        .then(() => {
          this.btnLoading = false
          this.$notify({
            title: '成功',
            message: '创建成功',
            type: 'success',
            duration: 2000
          })
          this.toggleGetList()
          this.closeDialogForm()
        }).catch(error => {
          this.btnLoading = false
          if (error.status === 2) {
            this.$message.error(error.message)
          }
        })
      },
      update() {
        axios.put('/user', this.ruleForm)
        .then(() => {
          this.btnLoading = false
          this.$notify({
            title: '成功',
            message: '更新成功',
            type: 'success',
            duration: 2000
          })
          this.toggleGetList()
          this.closeDialogForm()
        }).catch(error => {
          this.btnLoading = false
          if (error.status === 2) {
            this.$message.error(error.message)
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
        this.btnLoading = false
      },
      closeDialogForm() {
        this.$emit('closeDialogForm')
      },
      toggleGetList() {
        this.$emit('toggleGetList')
      },
      handleTypeChange() {
        this.ruleForm.type = this.ruleForm.types.join(',')
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
