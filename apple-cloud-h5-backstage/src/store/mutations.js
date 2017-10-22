import * as types from './mutation-types'

const mutations = {
  [types.SET_HIDE_LEFT_BAR](state, flag) {
    state.hideLeftBar = flag
  }
}

export default mutations
