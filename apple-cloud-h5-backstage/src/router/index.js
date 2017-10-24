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
      redirect: '/admin/dashboard'
    }, {
      path: '/login',
      component: Login
    }, {
      path: '/admin',
      component: Layout,
      children: [
        {
          path: 'dashboard',
          component: Dashboard
        }, {
          path: 'system/demo',
          component: Demo
        }, {
          path: 'userPage',
          component: UserPage
        }, {
          path: 'userForm',
          component: UserForm
        }, {
          path: 'userOther',
          component: UserOther
        }, {
          path: '401',
          component: FourZeroOne
        }, {
          path: '404',
          component: FourZeroFour
        }
      ]
    }, {
      path: '*',
      redirect: '/admin/404'
    }
  ]
})
