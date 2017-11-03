<template>
  <div class="header-box">
    <el-header header-align="left">
      <div class="header-wrap">
        <div class="btn-group">
          <el-button-group>
            <el-button type="primary" icon="el-icon-circle-plus" @click="handleCreate">新增
            </el-button>
            <el-button v-waves type="success" icon="el-icon-edit" @click="handleTopUpdate">修改
            </el-button>
            <el-button v-waves type="danger" icon="el-icon-delete" @click="handleBatchDelete">删除
            </el-button>
          </el-button-group>
        </div>
        <div class="search-form">
          <el-form
            :inline="true"
            :model="searchForm"
            class="demo-form-inline"
            align="left"
            ref="searchForm"
            v-show="!isShowMoreForm">
            <el-input placeholder="请输入内容" v-model="searchForm.name" style="width: 200px">
              <template slot="prepend">姓名</template>
            </el-input>
            <el-input placeholder="请输入内容" v-model="searchForm.name" style="width: 200px">
              <template slot="prepend">姓名</template>
            </el-input>
            <el-input placeholder="请输入内容" v-model="searchForm.name" style="width: 200px">
              <template slot="prepend">姓名</template>
            </el-input>
          </el-form>
          <transition name="slide-up">
            <div class="form-more-box"
                 v-show="isShowMoreForm">
              <i class="el-icon-circle-close-outline" @click="handleMoreForm"></i>
              <el-input v-for="item in 10" placeholder="请输入内容" v-model="searchForm.name"
                        style="width: 200px;margin:0 5px">
                <template slot="prepend">姓名</template>
              </el-input>
              <el-button-group v-show="isShowMoreForm">
                <el-button v-waves type="primary" icon="el-icon-search" @click="handleSearch">搜索 </el-button>
                <el-button v-waves type="warning" icon="el-icon-delete" @click="handleClearSearch">清空</el-button>
              </el-button-group>
            </div>
          </transition>
        </div>
        <div>
          <el-button type="primary" icon="el-icon-circle-plus" @click="handleMoreForm" v-show="isShowMoreBtn">更多>> </el-button>
          <el-button-group v-show="!isShowMoreForm">
            <el-button v-waves type="primary" icon="el-icon-search" @click="handleSearch">搜索 </el-button>
            <el-button v-waves type="warning" icon="el-icon-delete" @click="handleClearSearch"> 清空 </el-button>
          </el-button-group>
        </div>
      </div>

      <el-dialog :title="textMap[dialogStatus]"
                 top="91px"
                 class="my-dialog"
                 scope="scope"
                 :visible.sync="dialogFormVisible">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" align="left"
                 class="demo-ruleForm" center>
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
          <el-button icon="el-icon-refresh" @click="resetForm('ruleForm')">重 置</el-button>
          <el-button icon="el-icon-circle-close" @click="dialogFormVisible = false">取 消
          </el-button>
        </div>
      </el-dialog>
    </el-header>
  </div>
</template>

<script type="text/ecmascript-6">
  export default{}
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
