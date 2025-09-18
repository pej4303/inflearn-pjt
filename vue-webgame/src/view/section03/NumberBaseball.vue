<!-- 결론은 자바스크립라고 생각하면 된다 -->
<template>
    <div>
        <h1>{{ resultStr }}</h1>
        <form @submit.prevent="onSubmitForm">
            <input type="text" v-model="inputNum" ref="refInput" pattern="\d{4}"
                maxlength="4" minlength="4" placeholder="숫자 4자리 입력하세요."/>
            <button type="submit">입력</button>
        </form>
        <div>남은 시도 : {{ 10 - list.length }}</div><button @click="onClickBtn">새로 시작</button>
        <ul>
            <li v-for="(item, index) in list" :key="index">
                <span>{{ item.value }}</span>
                <br/>
                <span>{{ item.result }}</span>
            </li>
        </ul>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const inputNum = ref<string>('');   // 입력값
const resultStr = ref<string>('');  // 결과 메시지
const list = ref<any[]>([]);        // 시도 목록
const refInput = ref<HTMLInputElement|null>(null);

// 정답 숫자 배열
let answer: number[] = generateNumber();

function generateNumber() :number[] {
    const numbers :number[] = [];
    while (numbers.length < 4) {
        const n = Math.floor(Math.random() * 10);
        if (!numbers.includes(n)) {
        numbers.push(n);
        }
    }
    return numbers;
}

console.log('정답 =', answer.join(''));

// 새로 시작 버튼 클릭 이벤트
const onClickBtn = () => {
    if ( confirm('새로운 숫자야구 게임을 하시겠습니까?') ) {
        answer = generateNumber();
        console.log('정답 =', answer.join(''));

        inputNum.value = '';
        resultStr.value  = '';
        list.value = [];

        refInput.value?.focus();
    }
};

// 폼 제출 이벤트
const onSubmitForm = () => {
    if (!inputNum.value) {
        alert('4자리 숫자를 입력해주세요.');
        refInput.value?.focus();
        return;
    }
    // 중복 숫자 방지
    const hasDup = new Set(inputNum.value).size !== inputNum.value.length;
    if (hasDup) {
        alert('중복 숫자를 입력할 수 없습니다.');
        refInput.value?.focus();
        return;
    }

    if (list.value.length >= 9) {
        resultStr.value = `실패~ 정답은 ${answer.join('')} 입니다.`;
        onClickBtn();
    }

    if (inputNum.value === answer.join('')) {
        resultStr.value = '홈런~';
        onClickBtn();
    } else {
        const inputArr = inputNum.value.split('').map(i => parseInt(i));
        let strikeCnt = 0;
        let ballCnt = 0;
        
        for (let i=0; i <answer.length; i++) {
            if (answer[i] === inputArr[i]) {
                // 숫자랑 위치도 맞은 경우
                strikeCnt++;
            } else if (answer.includes(inputArr[i])) {
                // 숫자만 맞은 경우
                ballCnt++;
            }
        }

        list.value.push({
            value: inputNum.value,
            result: `${strikeCnt} 스트라이크 / ${ballCnt} 볼`
        });

        inputNum.value = '';
        refInput.value?.focus();
    }
};
</script>

<style scoped>
</style>
