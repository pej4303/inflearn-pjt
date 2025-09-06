<template>
    <div>
        <div id="screen" :class="state" @click="onClickScreen"> {{ message }}</div>
        <div v-show="timeList.length > 0">
            <div>현재 기록 : {{ currentTime + ' ms' }}</div>
            <div>평균 시간 : {{ avgTime + ' ms'}} </div>
            <button @click="onClickReset">초기화</button>
        </div>
    </div>
</template>

<script>
import { ref, computed } from 'vue';

export default {
    setup() {
        const message = ref('클릭해서 시작하세요.');
        const state = ref('waiting');  // div 영역 클래스명
        
        let startTime = 0;  // 시작 시간
        let endTime = 0;    // 종료 시간
        const timeList = ref([]);
        let timeoutId = null;

        // 현재 기록 (마지막 반응 시간)
        const currentTime = computed(() => {
            return timeList.value.length ? timeList.value[timeList.value.length - 1] : 0;
        });
        // 평균 기록
        const avgTime = computed(() => {
            if (timeList.value.length == 0) {
                return 0;
            } else {
                return (timeList.value.reduce((a, b) => a + b, 0) / timeList.value.length).toFixed(2) || 0;
            }
        });

        // 초기화 버튼 클릭 이벤트
        const onClickReset = () => {
            message.value = '클릭해서 시작하세요.';
            state.value = 'waiting';
            timeList.value = [];
        };

        // 스크린 영역 클릭 이벤트
        const onClickScreen = () => {
            switch(state.value) {
                case 'waiting':
                    state.value = 'ready';
                    message.value = '초록색이 되면 클릭하세요.';
                    
                    changeColor();
                    break;
                case 'ready':
                    clearTimeout(timeoutId); // 타이머 중복 방지
                    
                    state.value = 'waiting';
                    message.value = '너무 성급하시네요~ 초록색이 된 후에 클릭하세요';
                    break;
                case 'now':
                    endTime = new Date();
                    state.value = 'waiting';
                    message.value = '클릭해서 시작하세요.';
                    timeList.value.push(endTime - startTime);
                    break;
            }
        };

        // 색상 변경
        const changeColor = () => {
            // 2~3초 뒤에 색상 변경됨
            timeoutId = setTimeout(() => {
                state.value = 'now';
                message.value = '지금 클릭하세요.';

                startTime = new Date();
            }, Math.floor(Math.random() * 1000) + 2000);
        };

        const clearTime = () => {
            startTime = 0;
            endTime = 0;
        };

        return {
            message,
            state,
            currentTime,
            avgTime,
            timeList,
            onClickReset,
            onClickScreen,
            changeColor,
            clearTime,
        };
    },
};
</script>
<!--
scoped : 이 컴포넌트에만 유효한 css가 된다.
-->
<style scoped>
#screen {
    width: 300px;
    height: 200px;
    text-align: center;
    user-select: none;
}
#screen.waiting {
    background-color: aqua;
}
#screen.ready {
    background-color: red;
    color: white;
}
#screen.now {
    background-color: greenyellow;
}
</style>
