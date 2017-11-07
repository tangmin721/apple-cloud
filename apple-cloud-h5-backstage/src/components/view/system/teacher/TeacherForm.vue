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
      <el-form-item label="姓名" prop="name">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.name"
        ></el-input>
      </el-form-item>
      <el-form-item label="username描述@TODO'" prop="username">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.username"
        ></el-input>
      </el-form-item>
      <el-form-item label="身份证" prop="idCard">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.idCard"
        ></el-input>
      </el-form-item>
      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker
            type="date" placeholder="选择日期"
            v-model="ruleForm.birthday"
            format="yyyy-MM-dd"
            value-format="yyyy-MM-dd"
            style="width: 200px">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="出生时间" prop="birthdayTime">
        <el-date-picker
            type="date" placeholder="选择日期"
            v-model="ruleForm.birthdayTime"
            format="yyyy-MM-dd HH:mm:ss"
            value-format="yyyy-MM-dd HH:mm:ss"
            style="width: 200px">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="分数" prop="score">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.score"
        ></el-input>
      </el-form-item>
      <el-form-item label="出版的书籍数量" prop="book">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.book"
        ></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="num">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.num"
        ></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input-number
            v-model="ruleForm.age"
            :min="1"
            :max="100000"
            style="width: 100px"></el-input-number>
      </el-form-item>
      <el-form-item label="是否班主任" prop="classMater">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.classMater"
        ></el-input>
      </el-form-item>
      <el-form-item label="账户金额" prop="account">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.account"
        ></el-input>
      </el-form-item>
      <el-form-item label="是否是特级教师" prop="supper">
        <el-switch on-text="" off-text="" v-model="ruleForm.supper"></el-switch>
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
          name: [
            {required: true, message: '请填写姓名', trigger: 'blur'}
          ],
          username: [
            {required: true, message: '请填写username描述@TODO', trigger: 'blur'}
          ],
          idCard: [
            {required: true, message: '请填写身份证', trigger: 'blur'}
          ],
          birthday: [
            {required: true, message: '请填写出生日期', trigger: 'blur'}
          ],
          birthdayTime: [
            {required: true, message: '请填写出生时间', trigger: 'blur'}
          ],
          score: [
            {required: true, message: '请填写分数', trigger: 'blur'}
          ],
          book: [
            {required: true, message: '请填写出版的书籍数量', trigger: 'blur'}
          ],
          num: [
            {required: true, message: '请填写数量', trigger: 'blur'}
          ],
          classMater: [
            {required: true, message: '请填写是否班主任', trigger: 'blur'}
          ],
          account: [
            {required: true, message: '请填写账户金额', trigger: 'blur'}
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
        axios.post('/teacher', this.ruleForm)
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
        axios.put('/teacher', this.ruleForm)
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
