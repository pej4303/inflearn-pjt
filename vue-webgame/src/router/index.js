import { createRouter, createWebHistory } from 'vue-router'
import Home from '../view/Home.vue' // ✅ 홈 화면용 컴포넌트
import NumberBaseball from '../view/section03/NumberBaseball.vue';
import ResponseCheck from '../view/section04/ResponseCheck.vue';

const routes = [
  { path: '/', name: 'Home', component: App },
  { path: '/section03', name: '숫자 야구', component: NumberBaseball },
  { path: '/section04', name: '반응속도 체크', component: ResponseCheck }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router