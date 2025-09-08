<template>
    <table>
        <tbody>
            <tr v-for="(row, rowIndex) in tableData" :key="rowIndex">
                <td v-for="(cell, cellIndex) in row" :key="cellIndex" @click="onClickCell(rowIndex, cellIndex)">
                {{ cell }}
                </td>
            </tr>
        </tbody>
    </table>
    <div>{{ turn }}</div>
</template>

<script>
import { ref, } from 'vue';
export default {
    setup() {
        const tableData = ref([
            ['', '', ''],
            ['', '', ''],
            ['', '', ''],
        ]);
        const turn = ref('X');  // O, X 이렇게 서로 넘어감
        
        // 셀 클릭 이벤트
        const onClickCell = (rowIndex, cellIndex) => {
            console.log(rowIndex, cellIndex);

            // 클릭한 셀에 값이 이미 있으면 리턴
            if (tableData.value[rowIndex][cellIndex] !== '') {
                return;
            }

            // 클릭한 셀에 현재 턴 값 넣기
            tableData.value[rowIndex][cellIndex] = turn.value;

            // 턴 변경
            turn.value = (turn.value === 'O') ? 'X' : 'O';
        };

        return {
            tableData,
            turn,
            onClickCell,
        };
    },
};
</script>

<style scoped>
table {
    border-collapse: collapse;
}
td {
    border: 1px solid black;
    width: 80px;
    height: 80px;
    text-align: center;
}
</style>
