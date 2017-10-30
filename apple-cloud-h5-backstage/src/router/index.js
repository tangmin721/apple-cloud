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

const Demo = () => import('components/view/system/demo/demo')

const UserForm = () => import(/* webpackChunkName: "system-user" */ 'components/view/system/user/userForm')
const UserPage = () => import(/* webpackChunkName: "system-user" */ 'components/view/system/user/userPage')
const UserOther = () => import(/* webpackChunkName: "system-user" */ 'components/view/system/user/userOther')

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
        {name: 'demo模块', path: 'demo', component: Demo},
        {name: '用户page', path: 'userPage', component: UserPage},
        {name: '用户form', path: 'userForm', component: UserForm},
        {name: '用户Other', path: 'userOther', component: UserOther},
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
      redirect: '/admin/404'
    }
  ]
})
