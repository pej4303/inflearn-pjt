<template>
    <div>
        <div>당첨 숫자</div>
        <div>
            <lotto-ball v-for="item in showBallList" :key="item" :number="item">
            </lotto-ball>
        </div>
        <div v-if="isBonus">보너스!</div>
        <lotto-ball v-if="isBonus" :number="bonusNum"></lotto-ball>
        <button v-if="isBonus" @click="onClickRedo">한번 더!</button>
    </div>
</template>

<script>
import { ref, onMounted, onBeforeUnmount } from 'vue';
import LottoBall from './LottoBall.vue';

export default {
    components: { LottoBall },
    
    setup() {
        // 로또 번호 추첨 (6개 + 보너스 1개)
        const getLottoNumbers = () => {
            const candidate = Array.from({ length: 45 }, (_, i) => i + 1);
            const shuffled = candidate.sort(() => Math.random() - 0.5);

            return shuffled.slice(0, 7).sort((a, b) => a - b);
        };
        
        let timeList = [];

        let ballList = [];
        const showBallList = ref([]);
        const bonusNum = ref(0);
        const isBonus = ref(false);

        // 한번 더 버튼 클릭 이벤트트
        const onClickRedo = () => {
            // 로또 번호가 다시 나와야 한다.
            bonusNum.value = 0;
            isBonus.value = false;
            showBallList.value = [];

            ballList = getLottoNumbers();   // 로또 번호 목록
            showLottoBalls();
        };

        // 로또번호 보여주기
        const showLottoBalls = () => {
            for (let i=0; i<ballList.length - 1; i++) {
                timeList[i] = setTimeout(() => {
                    showBallList.value.push(ballList[i]);
                }, (i + 1) * 1000); // 1초, 2초, 3초 ...
            }

            timeList[6] = setTimeout(() => {
                bonusNum.value = ballList[6];
                isBonus.value = true;
            }, ballList.length * 1000); // 마지막 번호 이후에 보너스
        };

        onMounted(() => {
            ballList = getLottoNumbers();   // 로또 번호 목록
            showLottoBalls();
        });

        onBeforeUnmount(() => {
            timeList.forEach(t => clearTimeout(t));
        });

        return {
            ballList,
            showBallList,
            isBonus,
            bonusNum,
            onClickRedo
        };
    },
};
</script>
<style scoped>

</style>
