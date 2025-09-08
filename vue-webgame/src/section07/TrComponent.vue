<template>
  <tr>
    <td-component v-for="(item, index) in rowData" :key="index" 
      :cell-data="item" :cell-index="index" :row-index="rowIndex">
    </td-component>
  </tr>
</template>

<script>
import TdComponent from './TdComponent.vue';
export default {
    components : { 
      TdComponent,
    },
    props: {
      rowData: {
        type: Array,
        required: true,
      },
      rowIndex: {
        type: Number,
        required: true,
      },
    },
    setup(props) {
        return {

        }
    }
};
</script>

<style scoped>
</style>