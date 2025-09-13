## ✅ Vue Router
+ Vue에서 페이지 이동(라우팅) 을 담당하는 공식 라이브러리
+ 설치 및 설정
```
1. 라우터 설치
npm install vue-router

2. 라우터 설정 파일 만들기
보통 src/router/index.js 또는 src/router.js 에 설정

3. main.js에서 라우터 등록
import router from './router'
app.use(router)  // 라우터 등록
```

## ✅ Lazy Loading
+ 동적 import 방식
+ 사용자가 해당 경로로 이동할 때만 컴포넌트를 불러옴
+ 초기 로딩 속도 빨라지며, 큰 프로젝트일수록 효과가 큼
```
const routes = [
  { path: '/user/:id', name: 'User', component: () => import('../views/User.vue') }
];
```

## ✅ 네스트 라우팅 (Nested Routing)
+ 화면 안에서 다른 화면을 호출하는 경우 사용함
+ 예) 대시보드, 탭 화면 등
+ Tab.vue
```
<template>
  <div>
    <h1>탭화면</h1>
    <nav>
      <router-link to="/children/tab01">탭1</router-link>
      <router-link to="/children/tab02">탭2</router-link>
    </nav>
    <router-view></router-view> <!-- 자식 컴포넌트 렌더링 -->
  </div>
</template>

const routes = [
  {
    path: '/children',
    component: () => import('../views/Tab.vue'),
    children: [
        { path: '', component: () => import('../views/Tab01.vue') }, // 기본 탭
        { path: 'tab01', component: () => import('../views/Tab01.vue') },
        { path: 'tab02', component: () => import('../views/Tab02.vue') },
    ]
  }
];
```