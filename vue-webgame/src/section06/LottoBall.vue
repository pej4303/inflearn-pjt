<template>
    <div class="ball" :style="{ backgroundColor: ballColor }">
        {{ lottoNumber }}
    </div>
</template>

<script>
import { computed } from 'vue'

export default {
  props: {
    number: {
      type: Number,
      required: true,
    },
  },
  setup(props) {
    const lottoNumber = props.number;
    // 로또번호 배경색 변경
    const ballColor = computed(() => {
      if (props.number <= 10) {
        return 'red';
      }
      else if (props.number <= 20) {
        return 'orange';
      }
      else if (props.number <= 30) {
        return 'yellow';
      }
      else if (props.number <= 40) {
        return 'blue';
      }
      else {
        return 'green';
      }
    });

    return {
      lottoNumber,
      ballColor,
    }
  },
}
</script>

<style scoped>
.ball {
    display: inline-block;
    border: 1px solid black;
    border-radius: 20px;
    width: 40px;
    height: 40px;
    line-height: 40px;
    font-size: 20px;
    text-align: center;
    margin-right: 20px;
    color: white;
}
</style>