<template>
    <td @click="onClickTd">{{ cellData }}</td>
</template>
<script>
export default {
    props: {
        cellData: {
            type: String,
            required: true,
        },
        cellIndex: {
            type: Number,
            required: true,
        },
        rowIndex: {
            type: Number,
            required: true
        },
    },
    setup(props) {
        // td 클릭 이벤트
        const onClickTd = () => {
            console.log()
        };

        return {
            onClickTd
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