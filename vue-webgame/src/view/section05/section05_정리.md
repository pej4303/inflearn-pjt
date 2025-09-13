## ✅ Vue.js devtools
+ 크롬 확장프로그램에서 설치 가능
+ Vue 개발 시 상태 관리와 컴포넌트 구조를 시각적으로 확인 가능
+ data, props, computed 값 등을 직접 수정해서 즉시 반영되는 동작 테스트 가능

## ✅ Vue 3 라이프사이클
![라이프사이클](https://ko.vuejs.org/assets/lifecycle._trByeii.png)

+ beforeCreate → created
    + 아직 DOM 접근 불가, data 초기화는 가능
+ beforeMount → mounted
    + mounted 시점에 DOM 접근 가능
+ beforeUpdate → updated
    + 반응형 데이터 변경 시 실행
+ beforeUnmount → unmounted
    + 컴포넌트가 제거되기 전에 리소스 정리

> 👉 setup()을 쓰면 대부분의 로직은 created와 mounted 대체 가능

## ✅ async, await
+ `async`를 사용하는 이유는 await를 쓰기 위함
+ 비동기 같은 거 깔끔하게 쓰려고 사용함
+ async 함수는 항상 Promise를 반환하고 await는 Promise가 처리될 때까지 기다린 후 결과 반환
