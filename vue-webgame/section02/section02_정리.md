
## ✅ Vue 컴포넌트 정의 방식

###  1. 전역 컴포넌트 
+ 모든 Vue 인스턴스에서 사용 가능하다.
+ `app.component()` 메서드를 사용한다.
```html
<div id="root">
  <word-replay></word-replay>
</div>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script>
  const app = Vue.createApp({});

  // 전역 컴포넌트 등록
  app.component('word-replay', {
    template: `<h1>전역 컴포넌트</h1>`
  });

  app.mount('#root');
</script>

```

###  2.  지역 컴포넌트 
+  특정 Vue 인스턴스(또는 다른 컴포넌트) 안에서만 사용 가능하다.
```html
<div id="root">
  <word-replay></word-replay>
</div>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script>
  const WordReplay = {
    template: `<h1>지역 컴포넌트</h1>`
  };

  const app = Vue.createApp({
    components: {
      'word-replay': WordReplay
    }
  });

  app.mount('#root');
</script>
```
###  3.  싱글 파일 컴포넌트(SFC)
+ HTML, JS, CSS를 하나의 `.vue` 파일 안에 작성 가능 하며 실제 프로젝트에서 이 방식을 많이 사용한다.
+ Vue 3에서는 여러 루트 태그를 가질 수 있다.
```html
<template>
  <h1>싱글 파일 컴포넌트</h1>
  <p>Vue3에서는 여러 루트 태그 가능</p>
</template>

<script>
export default {
  name: 'WordReplay'
}
</script>

<style scoped>
h1 {
  color: blue;
}
</style>

```

## ✅ Vue 컴포넌트 작성 시 주의사항 (Vue 3 기준)

### 1. 이름 규칙
+ HTML은 대소문자를 구분하지 않기 때문에 **Vue에서는 케밥케이스를 쓰도록 권장한다.**
+ Vue에서는 HTML에서 케밥케이스로 작성한 이름을 카멜케이스로 변환해서 JS코드에서 사용 할 수 있게 해준다.
+  **케밥 케이스(kebab-case)**: `<my-component>` 처럼 소문자와 하이픈을 사용 (HTML 표준).  
+  **파스칼 케이스(PascalCase)**: `MyComponent.vue` 처럼 파일 이름은 보통 대문자로 시작.

### 2. data는 함수로 반환
+  `data`를 **객체가 아니라 함수로 반환**해야 한다.
+  각 컴포넌트 인스턴스별 독립적인 데이터를 가지도록 같은 객체를 공유하지 못하게 항상 새로운 객체를 만들어서 반환해줘야 한다.
```Javascript
export default {
  data() {
    return {
      count: 0
    }
  }
}
```
### 3. 템플릿 루트 태그
+ Vue2에서는 반드시 `<div>` 같은 **하나의 루트 태그**로 감싸야 한다.
+ Vue3에서는 여러 루트 태그 가능하지만 여전히 하나로 감싸는 게 가독성에 좋다.