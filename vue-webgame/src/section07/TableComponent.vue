<template>
    <table>
        <tr-component v-for="(row, index) in tableData" :row-data="row" :row-index="index" :key="index">
        </tr-component>
    </table>
</template>

<script>
import TrComponent from './TrComponent.vue';

export default {
    components : { 
        TrComponent,
    },
    props: {
        tableData: {
            type: Array,
            required: true,
        }
    },
    setup(props) {
        return {

        }
    }
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