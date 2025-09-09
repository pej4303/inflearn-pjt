<template>
    <table>
        <tbody>
            <tr v-for="(row, rowIndex) in store.tableData" :key="rowIndex">
                <td v-for="(cell, cellIndex) in row" :key="cellIndex" @click="store.onClickCell(rowIndex, cellIndex)">
                {{ cell }}
                </td>
            </tr>
        </tbody>
    </table>
    <div>{{ store.turn }} 님의 차례</div>
    <div>
        {{ store.message }}
        <button v-show="store.message" @click="store.onClickReset">다시 시작</button>
    </div>
</template>

<script>
import { useSection07Store } from '../stores/section07';
export default {
    setup() {
        const store = useSection07Store();
        return {
            store
        }
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
