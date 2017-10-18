import 'babel-polyfill'
import Vue from 'vue'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import fastclick from 'fastclick'

import 'common/stylus/index.styl'

Vue.use(Element, { size: 'mini' });
Vue.config.productionTip = false;
fastclick.attach(document.body);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App)
});
