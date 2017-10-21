import Vue from 'vue'
import Router from 'vue-router'

import Login from 'components/view/system/login'
import Layout from 'components/layout/layout'

import UserForm from 'components/view/system/user/userForm'
import UserPage from 'components/view/system/user/userPage'
import UserOther from 'components/view/system/user/userOther'

Vue.use(Router)

export default new Router({
  routes: [
    // { path: '/', redirect: '/index'},
    {
      path: '/login',
      component: Login
    }, {
      path: '/index',
      component: Layout,
      children: [
        {
          path: 'userPage',
          component: UserPage
        }, {
          path: 'userForm',
          component: UserForm
        }, {
          path: 'userOther',
          component: UserOther
        }
      ]
    }
  ]
})
