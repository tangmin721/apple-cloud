import * as types from './mutation-types'

const mutations = {
  [types.SET_USER](state, user) {
    state.user = user
  },
  [types.SET_HIDE_LEFT_BAR](state, flag) {
    state.hideLeftBar = flag
  },
  [types.SET_TAB_VIEW_LIST](state, tabViewList) {
    state.tabViewList = tabViewList
  }
}

export default mutations
