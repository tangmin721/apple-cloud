还需要做的配置说明:

1. 权限表



2. sql语句
  1) 运行sql语句
  2) 把sql语句追加到ddl定义文件夹里
  3) 编写 清除脚本 追加到ddl 清空脚本里

3. 修改路由配置文件
  1)apple-cloud-h5-backstage/src/router/index.js 增加
const ${entity.className} = () => import('components/view/system/${entity.firstLowName}/${entity.className}')

{name: '${CONFIG.modelName}', path: '${entity.firstLowName}', component: ${entity.className}},