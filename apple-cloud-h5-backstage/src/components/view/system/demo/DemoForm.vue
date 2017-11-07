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
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" align="left"
             class="demo-ruleForm" center v-if="dialogFormVisible">
      <el-form-item label="姓名" prop="name">
        <el-input prefix-icon="el-icon-service" style="width: 200px"
                  v-model.trim="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input-number v-model="ruleForm.age" :min="18" :max="60"
                         style="width: 100px"></el-input-number>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="ruleForm.status" disabled placeholder="请选择状态"
                   style="width: 200px">
          <el-option label="无效" value="invalid"></el-option>
          <el-option label="正常" value="normal"></el-option>
          <el-option label="删除" value="deleted"></el-option>
          <el-option label="禁用" value="disabled"></el-option>
          <el-option label="冻结" value="frozen"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthday"
                        format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                        style="width: 200px"></el-date-picker>
      </el-form-item>
      <el-form-item label="特级教师" prop="supper">
        <el-switch on-text="" off-text="" v-model="ruleForm.supper"></el-switch>
      </el-form-item>
      <el-form-item label="活动性质" prop="types">
        <el-checkbox-group v-model="ruleForm.types" @change="handleTypeChange">
          <el-checkbox label="美食线上活动" name="types"></el-checkbox>
          <el-checkbox label="地推活动" name="types"></el-checkbox>
          <el-checkbox label="线下主题活动" name="types"></el-checkbox>
          <el-checkbox label="单纯品牌曝光" name="types"></el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="班主任" prop="classMater">
        <el-radio-group v-model="ruleForm.classMater">
          <el-radio label="yes">是</el-radio>
          <el-radio label="no">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="账户余额" prop="account">
        <el-input prefix-icon="el-icon-service" style="width: 200px"
                  v-model="ruleForm.account"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="memo">
        <el-input type="textarea" v-model="ruleForm.memo"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button icon="el-icon-success" type="primary" @click="submitForm('ruleForm')"
                 :loading="btnLoading">确 定
      </el-button>
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
      // 自定义校验
      var checkAjaxName = (rule, value, callback) => {
        if (!value) {
          this.btnLoading = false
          callback(new Error('请输入姓名'))
        } else if (value.trim().length < 2 || value.trim().length > 33) {
          this.btnLoading = false
          callback(new Error('长度在 2 到 32 个字符'))
        } else {
          axios.post('/demo/isNameNotExist', {
            id: this.ruleForm.id,
            name: this.ruleForm.name
          }).then(res => {
            this.btnLoading = false
            if (!res.data) {
              callback(new Error('姓名不可用,数据库已存在记录'))
            } else {
              callback()
            }
          }).catch(error => {
            this.btnLoading = false
            callback(new Error(error.message))
          })
        }
      }
      return {
        btnLoading: false,
        textMap: {
          update: '编辑',
          create: '创建'
        },
        rules: {
          name: [
            {validator: checkAjaxName, trigger: 'blur'}
          ],
          birthday: [
            {required: true, message: '请选择日期', trigger: 'change'}
          ],
          status: [
            {required: true, message: '请选择状态', trigger: 'change'}
          ],
          types: [
            {type: 'array', required: true, message: '请至少选择一个', trigger: 'change'}
          ],
          account: [
            {required: true, message: '请输入账户余额'}
          ],
          memo: [
            {required: true, message: '请填写备注', trigger: 'blur'}
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
        axios.post('/demo', this.ruleForm)
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
        axios.put('/demo', this.ruleForm)
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
