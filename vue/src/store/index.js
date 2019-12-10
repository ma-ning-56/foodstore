import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

// 外围构建树结构
export default new Vuex.Store({

  strict: debug
})
