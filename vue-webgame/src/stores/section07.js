import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useSection07Store = defineStore('section07', () => {
  const tableData = ref([
      ['', '', ''],
      ['', '', ''],
      ['', '', ''],
  ]);
  const turn = ref('X');  // O, X 이렇게 서로 넘어감
  const message = ref(null);

  // 셀 클릭 이벤트
  const onClickCell = (rowIndex, cellIndex) => {
      // console.log(rowIndex, cellIndex);

      // 이미 승부가 결정났으면 클릭 막기
      if (message.value) {
          return;
      }
      // 클릭한 셀에 값이 이미 있으면 리턴
      if (tableData.value[rowIndex][cellIndex] !== '') {
          return;
      }

      // 클릭한 셀에 현재 턴 값 넣기
      tableData.value[rowIndex][cellIndex] = turn.value;

      // 가로, 세로, 대각선 모두 같은 값이면 승
      if (checkWin()) {
          message.value = `${turn.value}님의 승리!`;
      } else if (checkDraw()) {
          // 아니면 모든 칸의 값이 있으면 무승무
          message.value = `아쉽게도 무승부~`;
      } else {
          // 턴 변경
          turn.value = (turn.value === 'O') ? 'X' : 'O';
      }
  };

  // 다시 시작 버튼 클릭 이벤트
  const onClickReset = () => {
      tableData.value = [
          ['', '', ''],
          ['', '', ''],
          ['', '', ''],
      ];
      turn.value = 'X';
      message.value = null;
  };

  // 이겼는지 체크
  const checkWin = () => {
      // 가로 체크
      for (let i=0; i<3; i++) {
          if (tableData.value[i][0] === turn.value && 
              tableData.value[i][1] === turn.value && 
              tableData.value[i][2] === turn.value) {
              return true;
          }
      }
      // 세로 체크
      for (let i=0; i<3; i++) {
          if (tableData.value[0][i] === turn.value && 
              tableData.value[1][i] === turn.value && 
              tableData.value[2][i] === turn.value ) {
              return true;
          }
      }
      // 대각선 체크
      if (tableData.value[0][0] === turn.value && 
          tableData.value[1][1] === turn.value && 
          tableData.value[2][2] === turn.value ) {
          return true;
      }
      if (tableData.value[0][2] === turn.value && 
          tableData.value[1][1] === turn.value && 
          tableData.value[2][0] === turn.value ) {
          return true;
      }

      return false;
  };

  // 무승부인지 체크
  const checkDraw = () => {
      return tableData.value.flat().every(i => i !== '');
  };

  return {
      tableData,
      turn,
      message,
      onClickCell,
      onClickReset,
      checkWin,
      checkDraw,
  };
});
