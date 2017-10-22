import 'babel-polyfill'
import Vue from 'vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import fastclick from 'fastclick'

import 'common/stylus/index.styl'

Vue.use(Element, {size: 'mini'})
Vue.config.productionTip = false
fastclick.attach(document.body)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
