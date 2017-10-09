<template>
  <div class="app-wrapper">
    <div class="sidebar-container">sidebar-container</div>
    <div class="main-container">
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList2"
        list-type="picture">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default{
    data() {
      return {
        fileList2: [{
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }, {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }]
      }
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList)
      },
      handlePreview(file) {
        console.log(file)
      }
    }
  }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  @import "~common/stylus/mixin"

  .app-wrapper
    clearfix()
    position: relative
    height: 100%
    width: 100%
    &.hideSidebar
      .sidebar-container
        width: 36px
        overflow: inherit
      .main-container
        margin-left: 36px
    .sidebar-container
      background: red
      transition: width 1.28s ease-out;
      width: 180px
      height: 100%
      position: fixed
      top: 0
      bottom: 0
      left: 0
      z-index: 1001
      overflow-y: auto
      &::-webkit-scrollbar
        display: none
    .main-container
      background: green
      min-height: 100%
      transition: margin-left 1.28s ease-out
      margin-left: 180px
</style>
