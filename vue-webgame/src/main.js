import { createApp } from 'vue';
import NumberBaseball from './section03/NumberBaseball.vue'
import ResponseCheck from './section04/ResponseCheck.vue'
import RockScissorsPaper from './section05/RockScissorsPaper.vue';
import LottoGenerator from './section06/LottoGenerator.vue';

createApp(NumberBaseball).mount('#section03');
createApp(ResponseCheck).mount('#section04');
createApp(RockScissorsPaper).mount('#section05');
createApp(LottoGenerator).mount('#section06');