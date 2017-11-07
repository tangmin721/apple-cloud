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
<#list entity.myfieldListNotTransient as e><#if e.simpleTypeName=="Date">
      <el-form-item label="${e.columnComment}" prop="${e.fieldName}">
        <el-date-picker
            v-model="ruleForm.${e.fieldName}"
            <#if e.columnType=="date">type="date"
            placeholder="选择日期"
            format="yyyy-MM-dd"
            value-format="yyyy-MM-dd"<#elseif e.columnType=="datetime">type="datetime"
            placeholder="选择日期时间"
            format="yyyy-MM-dd HH:mm:ss"
            value-format="yyyy-MM-dd HH:mm:ss"</#if>
            style="width: 200px">
        </el-date-picker>
      </el-form-item>
      <#elseif e.simpleTypeName=="Boolean">
      <el-form-item label="${e.columnComment}" prop="${e.fieldName}">
        <el-switch on-text="" off-text="" v-model="ruleForm.${e.fieldName}"></el-switch>
      </el-form-item>
      <#elseif e.simpleTypeName=="Integer">
      <el-form-item label="${e.columnComment}" prop="${e.fieldName}">
        <el-input-number
            v-model="ruleForm.${e.fieldName}"
            :min="1"
            :max="100000"
            style="width: 100px"></el-input-number>
      </el-form-item>
      <#else>
      <el-form-item label="${e.columnComment}" prop="${e.fieldName}">
        <el-input
            prefix-icon="el-icon-service"
            style="width: 200px"
            v-model.trim="ruleForm.${e.fieldName}"
        ></el-input>
      </el-form-item>
      </#if>
    </#list>
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
        rules: {<#list entity.myfieldListNotTransient as e><#if e.simpleTypeName!="Boolean" && e.simpleTypeName!="Integer">
          ${e.fieldName}: [
            {required: true, message: '请填写${e.columnComment}', trigger: 'blur'}
          ],</#if></#list>
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
        axios.post('/${CONFIG.requestMapPath}', this.ruleForm)
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
        axios.put('/${CONFIG.requestMapPath}', this.ruleForm)
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
