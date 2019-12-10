import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/page/Main'
import Login from '@/page/login/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main', // 主页
      component: Main
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    }
  ]
})
