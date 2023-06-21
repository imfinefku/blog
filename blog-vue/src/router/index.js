import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index2',
      component: resolve => require(['@/components/service/index2.vue'],resolve),
      children: [
        {
          path: '/',
          name: 'index3',
          component: resolve => require(['@/components/service/index3.vue'],resolve)
        }, {
          path: '/guidang',
          name: 'guidang',
          component: resolve => require(['@/components/service/guidang.vue'],resolve)
        }, {
          path: '/messageBoard',
          name: 'messageBoard',
          component: resolve => require(['@/components/service/messageBoard.vue'],resolve)
        }, {
          path: '/content',
          name: 'content',
          component: resolve => require(['@/components/service/content.vue'],resolve)
        }, {
          path: '/search',
          name: 'search',
          component: resolve => require(['@/components/service/search.vue'],resolve)
        },
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: resolve => require(['@/components/login.vue'],resolve)
    },
  ]
})
