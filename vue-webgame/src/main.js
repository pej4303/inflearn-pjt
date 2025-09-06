import { createApp } from 'vue';
import NumberBaseball from './section03/NumberBaseball.vue'
import ResponseCheck from './section04/ResponseCheck.vue'
import RockScissorsPaper from './section05/RockScissorsPaper.vue';

createApp(NumberBaseball).mount('#section03');
createApp(ResponseCheck).mount('#section04');
createApp(RockScissorsPaper).mount('#section05');