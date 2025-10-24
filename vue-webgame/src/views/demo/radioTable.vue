<script setup lang="ts">
import { ref, computed } from 'vue';
import { Table, type TableColumnsType } from 'ant-design-vue';  // ✅ 여기서 import 필수

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
        customCell: (record: DataItem) => ({
          onClick: () => handleRowClick(record),
          style: {
            cursor: 'pointer',
            backgroundColor: selectedRowKey.value === record.id ? '#ffeebb' : '',
          },
        }),
    },
    { 
        title: '이름', 
        dataIndex: 'name' ,
        key: 'name',
        width: 100,
        customCell: (record: DataItem) => ({
          onClick: () => handleRowClick(record),
          style: {
            cursor: 'pointer',
            backgroundColor: selectedRowKey.value === record.id ? '#ffeebb' : '',
          },
        }),
    },
    { 
        title: '이메일', 
        dataIndex: 'email',
        key: 'email',
        width: 300,
        customCell: (record: DataItem) => ({
          onClick: () => handleRowClick(record),
          style: {
            cursor: 'pointer',
            backgroundColor: selectedRowKey.value === record.id ? '#ffeebb' : '',
          },
        }),
     },
];

const selectedRowKey = ref<string | number>(); // 단일 선택
const selectedData = ref<DataItem>();
const rowSelection = computed(() => ({
  type: 'radio' as const,  // ✅ 타입 리터럴로 지정
  selectedRowKeys: selectedRowKey.value !== undefined ? [selectedRowKey.value] : [],
  onChange: (keys: (string | number)[], rows: DataItem[]) => {
    console.log('onChange');
    selectedRowKey.value = keys[0];    // 첫 번째 값만 사용
    selectedData.value = rows[0] as DataItem;
  },
}));

// const customRow = (record: DataItem) => ({
//   onClick: () => {
//     console.log('onRowClick');
//     selectedRowKey.value = record.key as string;
//     selectedData.value = record;
//   },
// });
const handleRowClick = (record: DataItem) => {
  console.log('handleRowClick:', record)
  selectedRowKey.value = record.key as string;
  selectedData.value = record;
}

const onTableClick = (e: MouseEvent) => {
  const row = (e.target as HTMLElement).closest('.ant-table-cell')
  if (row) {
    const key = row.getAttribute('data-row-key')
    console.log('행 클릭됨:', key)
  }
}
</script>
<template>
<!--
:custom-row="customRow"
-->
  <a-card title="테이블 테스트2" class="mt-4">
    <Table class="mt-3"
      :columns="columns" :data-source="data"
      row-key="key" 
      :row-selection="rowSelection"
    ></Table>
  </a-card>
</template>