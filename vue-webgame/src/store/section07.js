import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useTicTacToeStore = defineStore('ticTacToe', () => {
  const turn = ref('O');
  const tableData = ref([
    ['', '', ''],
    ['', '', ''],
    ['', '', ''],
  ]);

  const setCell = (row, col) => {
    if (tableData.value[row][col] === '') {
      tableData.value[row][col] = turn.value;
      toggleTurn();
    }
  };

  const toggleTurn = () => {
    turn.value = turn.value === 'O' ? 'X' : 'O';
  };

  const resetTable = () => {
    tableData.value = [
      ['', '', ''],
      ['', '', ''],
      ['', '', ''],
    ];
    turn.value = 'O';
  };

  return { turn, tableData, setCell, toggleTurn, resetTable };
});
