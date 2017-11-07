import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

// 登录页
const Login = () => import('components/view/system/login/login')
// 系统首页
const Dashboard = () => import('components/view/system/dashboard/dashboard')
const Layout = () => import('components/layout/layout')
const FourZeroOne = () => import('components/error/401')
const FourZeroFour = () => import('components/error/404')

const Demo = () => import('components/view/system/demo/Demo')
const Teacher = () => import('components/view/system/teacher/Teacher')
const DemoAndTeacher = () => import('components/view/system/demoAndTeacher/DemoAndTeacher')

const User = () => import('components/view/system/user/User')

// const UserPage = () => import(/* webpackChunkName: "system-user" */ 'components/view/system/user/userPage')

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/system/index'
    }, {
      path: '/login',
      component: Login
    }, {
      path: '/system',
      component: Layout,
      redirect: '/system/index',
      children: [
        {name: '首页', path: 'index', component: Dashboard},
        {name: '用户管理', path: 'user', component: User},
        {name: 'demo模块', path: 'demo', component: Demo},
        {name: '教师代码生成', path: 'teacher', component: Teacher},
        {name: '多模块聚合', path: 'demoAndTeacher', component: DemoAndTeacher},
        {name: '401错误页', path: '401', component: FourZeroOne},
        {name: '404错误页', path: '404', component: FourZeroFour}
      ]
    }, {
      path: '/eshop',
      redirect: '/eshop/index',
      component: Layout,
      children: [
        {name: 'e店', path: 'index', component: Dashboard},
        {name: 'spu', path: 'demo', component: Demo},
        {name: 'sku', path: 'demo', component: Demo}
      ]
    }, {
      path: '*',
      redirect: '/system/404'
    }
  ]
})
