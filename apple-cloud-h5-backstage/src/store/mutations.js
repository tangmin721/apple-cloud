import * as types from './mutation-types'

const mutations = {
  [types.SET_USER](state, user) {
    state.user = user
  },
  [types.SET_HIDE_LEFT_BAR](state, flag) {
    state.hideLeftBar = flag
  },
  [types.SET_USER](state, tabViews) {
    state.tabViews = tabViews
  }
}

export default mutations
