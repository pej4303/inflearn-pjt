## ✅ Pinia
+ Vue 3에서 권장되는 전역 상태 관리 라이브러리
+ 사용 목적
    + Vue는 기본적으로 단방향 데이터 흐름(부모 → 자식) 구조라서 형제 컴포넌트끼리 데이터를 주고받기 번거로움
    + props나 emit을 복잡하게 거치지 않고 데이터 공유 가능
+ 예: 장바구니 수량, 로그인 상태, 사용자 정보 같은 데이터를 저장함
+ 설치 및 설정
```
1. 설치
npm install pinia

2. main.js에 Pinia 등록
import { createPinia } from 'pinia';

const app = createApp(App);
app.use(createPinia());
app.mount('#app');

3. 전역 상태(store) 만들기
src/stores/section07.js
```