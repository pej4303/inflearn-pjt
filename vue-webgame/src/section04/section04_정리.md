## ✅ 웹팩(Webpack) 자동 빌드

+ `package.json` 파일 수정
```JSON
"scripts": {
    "build": "webpack --watch"
},
```

## ✅ webpack-dev-server
+ 화면 수정시 자동으로 빌드하고 화면을 보여줌
+ `--watch` 명령어로 해도 되지만 이게 더 편함

## ✅ 명령어 정리
```bash
# css 로더 설치
npm install -D vue-loader@next style-loader css-loader

# webpack.config.js - module.rules 에 추가
{
    test: /\.css$/,
    use: ['style-loader', 'css-loader']
},

# webpack-dev 설치
npm install -D webpack-dev-server
# package.json에 추가
"scripts": {
    "dev": "webpack serve"
},

# 서버 실행 명령어
npm run dev
```
## ✅ computed
+ Vue는 데이터가 변경될때 마다 화면을 다시 그리기 때문에 계산식 같은 부분에 사용하면 속도측면에서 좋음

## ✅ v-show 와 v-if 차이
+ `v-show`는 태그를 만들지만 `display:none` CSS 속성으로 동작
+ `v-if`는 태그 자체를 만들지 않고 조건에 부합하면 다시 생성함