<template>
    <div>
        <input type="number" placeholder="가로" v-model="mineData.row" />
        <input type="number" placeholder="세로" v-model="mineData.cell" />
        <input type="number" placeholder="지뢰개수" v-model="mineData.mine" />
        <button @click="onClickGameStart">게임 시작!</button>
        <button @click="onClickReset">다시 시작</button>
    </div>
    <div>{{ gameTime }} </div>
    <br />
    <table>
        <tbody>
            <tr v-for="(row, rowIndex) in tableData" :key="rowIndex">
                <td v-for="(cell, cellIndex) in row" :key="cellIndex" 
                    :style="getCellDataStyle(rowIndex, cellIndex)" 
                    @click="onClickCell(rowIndex, cellIndex)"
                    @contextmenu.prevent="onContextmenuCell(rowIndex, cellIndex)">
                {{ getCellDataText(rowIndex, cellIndex) }}
                </td>
            </tr>
        </tbody>
    </table>
    <br />
    <div>
        {{ message }}
    </div>
</template>

<script>
import { ref, watch, onUnmounted } from "vue";

const CODE = {
    MINE: -7,
    NORMAL: -1,
    QUESTION: -2,
    FLAG: -3,
    QUESTION_MINE: -4,
    FLAG_MINE: -5,
    CLICKED_MINE: -6,
    OPENED: 0,
};

export default {
    setup() {
        const tableData = ref([]);
        const mineData = ref({
            row: 10, // 지뢰찾기 행
            cell: 10, // 지뢰 찾기 열
            mine: 20 // 지뢰 개수
        });

        const isTimeStart = ref(false); // 타이머 실행 여부
        const gameTime = ref(0);        // 게임 타이머
        let timerId = null;             // 타이머 ID

        const message = ref('');  // 하단 문구

        // isTimeStart 값에 따라 자동으로 타이머 실행, 중지
        watch(isTimeStart, (newValue) => {
            if (newValue) {
                // 타이머 시작
                timerId = setInterval(() => {
                    gameTime.value++;
                }, 1000);
            } else {
                // 타이머 중지
                clearInterval(timerId);
            }
        });

        // 셀 스타일 가져오기
        const getCellDataStyle = (rowIndex, cellIndex) => {
            switch (tableData.value[rowIndex][cellIndex]) {
                case CODE.NORMAL:
                case CODE.MINE:
                    return { background: '#444'};
                case CODE.CLICKED_MINE:
                case CODE.OPENED:
                    return { background: 'white'};
                case CODE.FLAG:
                case CODE.FLAG_MINE:
                    return { background: 'red'};
                case CODE.QUESTION:
                case CODE.QUESTION_MINE:
                    return { background: 'yellow'};
                default:
                    return {};
            }
        };

        // 셀 데이터 가져오기
        const getCellDataText = (rowIndex, cellIndex) => {
            const cellData = tableData.value[rowIndex][cellIndex];

            switch (cellData) {
                case CODE.MINE:
                    return 'X';
                case CODE.CLICKED_MINE:
                    return '펑';
                case CODE.FLAG:
                case CODE.FLAG_MINE:
                    return '!';
                case CODE.QUESTION:
                case CODE.QUESTION_MINE:
                    return '?';
                case CODE.NORMAL:
                case CODE.OPENED:
                    return ' '; // 아직 안 열리거나 열린 빈칸
                default:
                    // 숫자로 열린 칸 (0이면 빈칸)
                    return cellData === 0 ? ' ' : cellData;
            }
        };

        
        // 게임 시작 클릭 이벤트
        const onClickGameStart = () => {
            // 지뢰찾기 테이블 만들기
            const tmpData = plantMine(
                mineData.value.row,
                mineData.value.cell,
                mineData.value.mine
            );
            tableData.value = tmpData; // 만들어진 데이터 화면에 반영

            // 타이머 시작
            isTimeStart.value = true;
        };

        // 우클릭 이벤트
        const onContextmenuCell = (rowIndex, cellIndex) => {
            if (!isTimeStart.value) { 
                return false;
            }

            switch (tableData.value[rowIndex][cellIndex]) {
                case CODE.NORMAL:
                    tableData.value[rowIndex][cellIndex] = CODE.FLAG;
                    break;
                case CODE.MINE:
                    // 깃발이 나오게
                    tableData.value[rowIndex][cellIndex] = CODE.FLAG_MINE;
                    break;
                case CODE.FLAG_MINE:
                    tableData.value[rowIndex][cellIndex] = CODE.QUESTION_MINE;
                    break;
                case CODE.FLAG:
                    // 물음표 나오게
                    tableData.value[rowIndex][cellIndex] = CODE.QUESTION;
                    break;
                case CODE.QUESTION:
                    tableData.value[rowIndex][cellIndex] = CODE.NORMAL;
                    break;
                case CODE.QUESTION_MINE:
                    // 빈칸으로 나오게
                    tableData.value[rowIndex][cellIndex] = CODE.MINE;
                    break;
            }
        };

        // 셀 클릭 이벤트
        const onClickCell = (rowIndex, cellIndex) => {
            if (!isTimeStart.value) { 
                return false;
            }

            let cellData = tableData.value[rowIndex][cellIndex];
            if (cellData === CODE.NORMAL) {
                const mineCnt = getMineCnt(rowIndex, cellIndex);
                console.log(mineCnt);
                tableData.value[rowIndex][cellIndex] = mineCnt; // 주변 지뢰 수로 표시
            } else if (cellData === CODE.MINE) {
                tableData.value[rowIndex][cellIndex] = CODE.CLICKED_MINE;
                isTimeStart.value = false;
                message.value = '💥 폭탄 터짐!';
            }
        };

        // 다시 시작 버튼 클릭 이벤트
        const onClickReset = () => {
            // 다시 시작 할것인지 물어보기
            if (confirm('다시 시작 하시겠습니까?')) {
                // 변수 초기화
                gameTime.value = 0;
                isTimeStart.value = false;
                message.value = ''; 
                tableData.value = [];
            }
        };
        
        // 주변 지뢰 개수 찾기 
        const getMineCnt = (rowIndex, cellIndex) => {
            let count = 0;
            const directions = [
                [-1, -1], [-1, 0], [-1, 1],
                [0, -1],          [0, 1],
                [1, -1], [1, 0], [1, 1],
            ];

            directions.forEach(([dx, dy]) => {
                const newRow = rowIndex + dx;
                const newCol = cellIndex + dy;

                // 범위 체크
                if (newRow >= 0 && newRow < tableData.value.length &&
                    newCol >= 0 && newCol < tableData.value[0].length) {
                    const cell = tableData.value[newRow][newCol];
                    if (cell === CODE.MINE || cell === CODE.FLAG_MINE || cell === CODE.QUESTION_MINE) {
                        count++;
                    }
                }
            });

            return count;
        };

        // 지뢰 심기
        const plantMine = (row, cell, mine) => {
            const candidate = Array(row * cell).fill().map((arr, i) => {
                return i;
            })

            const shuffle = [];
            while( candidate.length > row * cell - mine) {
                const chosen = candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0];
                shuffle.push(chosen);
            }

            const data = [];
            for (let i=0; i<row; i++) {
                const rowData = [];
                data.push(rowData);
                for (let j=0; j<cell; j++) {
                    rowData.push(CODE.NORMAL);
                }
            }

            for (let k=0; k<shuffle.length; k++) {
                const ver = Math.floor(shuffle[k] / cell);
                const hor = shuffle[k] % cell;
                data[ver][hor] = CODE.MINE;
            }

            return data;
        };

        // 혹시 컴포넌트 사라질 때 타이머 정리
        onUnmounted(() => {
            clearInterval(timerId);
        });

        return {
            tableData,
            mineData,
            isTimeStart,
            gameTime,
            message,
            getCellDataStyle,
            getCellDataText,
            onClickGameStart,
            onContextmenuCell,
            onClickCell,
            onClickReset,
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
    width: 30px;
    height: 30px;
    text-align: center;
}
</style>
