<script setup lang="ts">
import { ref, computed, reactive } from 'vue'
import type { TableColumnsType } from 'ant-design-vue'
import type { Key } from 'ant-design-vue';
import { Table } from 'ant-design-vue';  // ✅ 여기서 import 필수
interface DataItem {
    key ?: string | null;
    id    : string | null;
    name  : string | null;
    email : string | null;
}

const data = ref<DataItem[]>([
    { key: '1', id: '1', name: '홍길동', email: 'hong@test.com' },
    { key: '2', id: '2', name: '이몽룡', email: 'lee@test.com' },
    { key: '3', id: '3', name: '임꺽정', email: 'lim@test.com' },
    { key: '4', id: '4', name: '성춘향', email: 'seong@test.com' },
    { key: '5', id: '5', name: '이순신', email: 'lee@test.com' },
    { key: '6', id: '6', name: '강감찬', email: 'kang@test.com' },
    { key: '7', id: '7', name: '을지향', email: 'eulji@test.com' },
    { key: '8', id: '8', name: '윤봉길', email: 'yun@test.com' },
    { key: '9', id: '9', name: '이율곡', email: 'lee@test.com' },
]);
const columns: TableColumnsType = [
    { 
        title: 'ID', 
        dataIndex: 'id' ,
        key: 'id',
        width: 100,
        align: 'center',
    },
    { 
        title: '이름', 
        dataIndex: 'name' ,
        key: 'name',
        width: 100,
    },
    { 
        title: '이메일', 
        dataIndex: 'email',
        key: 'email',
        width: 300,
     },
];

const selectedRowKey = ref<Key[]>([]); // 초기값도 빈 배열로
const selectedDataList = ref<DataItem[]>([]);

const rowSelection = computed(() => ({
  selectedRowKeys: selectedRowKey.value,
  onChange: (keys: Key[], rows: DataItem[]) => {
    selectedRowKey.value = keys;
    selectedDataList.value = rows;
  },
}));

// const rowSelection = reactive({
// //   type: 'radio', // 필요하면 라디오로 변경 가능
//   selectedRowKeys: selectedRowKey.value, // 1차원 배열 그대로 사용
//   onChange: (keys: Key[], rows: DataItem[]) => {
//     selectedRowKey.value = keys;
//     selectedDataList.value = rows;
//   },
// });

// const rowSelection = reactive({
//     // type: 'radio',
//     selectedRowKeys: selectedRowKey.value ? [selectedRowKey.value] : [],
//     onChange: (keys: string[], rows: DataItem[]) => {
//         selectedRowKey.value = keys[0];
//         selectedDataList.value = rows;
//     },
//     // You can also add other options here, like `type: 'radio'` for single selection
//     // or `getCheckboxProps` to disable specific row checkboxes.
// });

const customRow = (record: DataItem) => ({
  onClick: () => {
    console.log('onRowClick');
  },
});
</script>
<template>
    <a-card title="테이블 테스트" class="mt-4">
      <Table class="mt-3"
        :columns="columns" :data-source="data"
        row-key="key" 
        :row-selection="rowSelection"
      ></Table>
    </a-card>
</template>
<style scoped>
/* 선택된 행 기본 파란색 덮어쓰기 */
.ant-table-row-selected > td {
  background-color: green !important; /* 원하는 색 */
}
.mt-3 {
margin-top: 1rem;
}
.mt-4 {
margin-top: 1.5rem;
}
</style>