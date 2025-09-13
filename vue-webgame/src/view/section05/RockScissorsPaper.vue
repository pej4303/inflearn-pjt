<template>
    <div>
        <div id="computer" :style="{ background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${imgPosX} 0`}"></div>
        <div>
            <button @click="onClickGame('rock')">바위</button>
            <button @click="onClickGame('scissor')">가위</button>
            <button @click="onClickGame('paper')">보</button>
        </div>
        <div>{{ result }}</div>
        <div>현재 {{ score }} 점</div>
    </div>
</template>

<script>
import { ref, onMounted, onBeforeUnmount } from 'vue';

export default {
    setup() {
        const score = ref(0);      // 점수
        const result = ref('');    // 결과
        const imgPosCode = { 
            rock:'0', 
            scissor:'-142px', 
            paper:'-284px' 
        };
        const imgPosX = ref(imgPosCode['rock']);    // 가위바위보 이미지 좌표
        const options = Object.keys(imgPosCode);
        const intervalId = ref(null);

        // 이미지 애니메이션 시작
        const startImgInterval = () => {
            return setInterval(() => {
                const randomChoice = options[Math.floor(Math.random()*3)];
                imgPosX.value = imgPosCode[randomChoice];
            }, 200);
        };
        // 이미지 애니메이션 중지
        const stopImgInterval = () => {
            clearInterval(intervalId.value);
            intervalId.value = null;
        };

        // 가위바위보 클릭 이벤트
        const onClickGame = (choice) => {
            // 애니메이션 중지
            stopImgInterval();

            // 컴퓨터 선택
            const computerChoice = options[Math.floor(Math.random()*3)];
            imgPosX.value = imgPosCode[computerChoice];

            if (choice === computerChoice) {
                // 비겼다
                result.value = '비겼습니다.';
            } else if (
                (choice === 'rock' && computerChoice === 'paper') ||
                (choice === 'scissor' && computerChoice === 'rock') ||
                (choice === 'paper' && computerChoice === 'scissor') 
            ) {
                // 졌다
                result.value = "졌습니다.";
                score.value--;
            } else {
                // 이겼다
                result.value = "이겼습니다.";
                score.value++;
            }

            setTimeout(() => {
                intervalId.value = startImgInterval();
            }, 1000);
        };

        // 마운트 시 실행
        onMounted(() => {
            intervalId.value = startImgInterval();
        });
       

        onBeforeUnmount(() => {
            stopImgInterval();
        });

        return {
           score,
           result,
           imgPosX,
           onClickGame
        };
    },
};
</script>
<style scoped>
#computer {
    width: 142px;
    height: 200px;
    background-position: 0 0;
}
</style>
