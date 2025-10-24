# 📌 프로젝트명

> 웹 게임을 만들며 배우는 Vue
---

## 📂 프로젝트 구조

```bash
public
  └─ index.html         # 프로젝트 진입점 HTML
src
  ├─ router
  │   └─ index.ts       # Vue Router 설정 파일, 페이지 라우팅 관리
  ├─ store
  │   └─ section07.ts   # Pinia 전역 상태 관리 파일(틱택토 전용)
  ├─ views               
  │   ├─ demo      
  │   ├─ section04      
  │   ├─ section05       
  │   ├─ section06       
  │   ├─ section07       
  │   ├─ section08       
  │   └─ section09       
  ├─ App.vue             # 최상위 루트 컴포넌트
  └─ main.ts             # Vue 앱 초기화 및 전역 설정

```
## 📌 초기 렌더링 흐름
```
index.html
    │
    ▼
main.js
    │  - Vue 앱 생성
    │  - 라우터(router)와 상태관리(store) 연결
    │  - App.vue 마운트
    ▼
App.vue 렌더링
    │  - 공통 레이아웃 렌더링
    │  - <router-view>에 URL에 맞는 Section 컴포넌트 삽입
    ▼
Section 컴포넌트 렌더링
    │  - Section별 게임/학습 UI 표시
```

## 🚀 기술 스택

### ✅ Frontend
+ Vue 3 Composition API
+ Vue Router : 페이지 이동, 탭/네스트 라우팅
+ Pinia : 전역 상태 관리
+ TypeScript
+ Ant Design Vue : UI 컴포넌트 라이브러리

### ✅ Development Tools
+  vite
+ npm
---

## 🧩 로컬 실행 방법
```bash
npm run dev
```
## 📦 설치 명령어
```bash
# 1. 프로젝트 생성
npm create vite@latest vue-webgame

# 2. Ant Design Vue 설치
npm install ant-design-vue@next --save
```