
## ✅ Vue 컴포넌트 정의 방식

###  1. 전역 컴포넌트 
+ 모든 Vue 인스턴스에서 사용 가능 하다.
```html
<div id="root">
  <word-replay></word-replay>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue@2.7.16/dist/vue.min.js"></script>
<script>
  // 전역 컴포넌트 등록
  Vue.component('word-replay', {
    template: '<h1>전역 컴포넌트</h1>'
  });
  const app = new Vue({
    el: '#app'
  });
</script>
```