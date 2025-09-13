import { createRouter, createWebHistory } from 'vue-router'
import Home from '../view/Home.vue' // 홈 화면용 컴포넌트
import NumberBaseball from '../view/section03/NumberBaseball.vue';
import ResponseCheck from '../view/section04/ResponseCheck.vue';
import RockScissorsPaper from '../view/section05/RockScissorsPaper.vue';
import LottoGenerator from '../view/section06/LottoGenerator.vue';
import TicTacToe from '../view/section07/TicTacToe.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/section03', name: '숫자 야구', component: NumberBaseball },
  { path: '/section04', name: '반응속도 체크', component: ResponseCheck },
  { path: '/section05', name: '가위바위보', component: RockScissorsPaper },
  { path: '/section06', name: '로또번호 추첨기', component: LottoGenerator },
  { path: '/section07', name: '틱택토', component: TicTacToe },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router