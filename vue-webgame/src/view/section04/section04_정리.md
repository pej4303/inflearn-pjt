## ✅ 웹팩(Webpack) 자동 빌드   
+ `webpack --watch` : 파일 수정 시 자동 빌드
+ `package.json` 파일에 추가
```JSON
"scripts": {
    "build": "webpack --watch"
},
```

## ✅ webpack-dev-server 
+ 화면 수정시 자동으로 빌드하고 화면을 보여줌 
+  역할: 코드 수정 시 자동 빌드 + 브라우저에 바로 반영
+  `--watch` 보다 편리함
+  설치 및 설정
```bash
npm install -D webpack-dev-server

# package.json 파일에 추가
"scripts": {
    "dev": "webpack serve"
}
```
+ 서버 실행
```bash
npm run dev
```

## ✅ CSS Loader 설정
+ 설치 및 설정
```
bash
# css 로더 설치
npm install -D vue-loader@next style-loader css-loader

# webpack.config.js - module.rules 에 추가
module: {
    rules: [
        {
            test: /\.css$/,
            use: ['style-loader', 'css-loader']
        }
    ]
}
```

## ✅ computed 
+ 데이터 변경 시 계산식 자동 갱신
```
const sum = computed(()  =>  {
	return a + b;
});
```
+ Vue는 데이터가 변경될때 마다 화면을 다시 그리기 때문에 계산식 같은 부분에 사용하면 렌더링 효율을 높일 수 있

## ✅ v-show 와 v-if 차이 
+ `v-show`는 태그를 만들지만 `display:none` CSS 속성으로 동작 
+ `v-if`는 태그 자체를 만들지 않고 조건에 부합하면 다시 생성함

## ✅ scoped
+ Vue에서 CSS 처리시 해당 컴포넌트 내부에서만 스타일 적용되게 할 수 있음
+ 컴포넌트 외부에는 영향 없음
```html
<style scoped>
.box {
  color: red;
}
</style>
```