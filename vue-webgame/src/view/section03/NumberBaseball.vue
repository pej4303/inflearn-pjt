<!-- 결론은 자바스크립라고 생각하면 된다 -->
<template>
    <div>
        <h1>{{ resultStr }}</h1>
        <form @submit.prevent="onSubmitForm">
            <input type="text" v-model="inputNum" ref="refInput" pattern="\d{4}"
                maxlength="4" minlength="4" placeholder="숫자 4자리 입력하세요."/>
            <button type="submit">입력</button>
        </form>
        <!-- <div>남은 시도 : {{ 10 - list.length }}</div><button @click="onClickBtn">새로 시작</button>
        <ul>
            <li v-for="(item, index) in list" :key="index">
                <span>{{ item.value }}</span>
                <br/>
                <span>{{ item.result }}</span>
            </li>
        </ul> -->
    </div>
</template>

<script lang="ts">
import { ref } from 'vue';

export default {
    setup() {
        const inputNum = ref<String>('');        // 입력값
        const resultStr = ref<String>('');

        return {
            inputNum,
            resultStr
        }
    }
};
</script>

<style scoped>
</style>
