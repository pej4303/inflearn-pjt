##  ✅ 웹팩(Webpack)
+  **사용 목적**: 여러 개의 JS, CSS, Vue 파일 등을 하나(또는 몇 개)로 **합쳐주는 역할**
+  **주요 영역**:
	1.  **Entry(진입점)**: 애플리케이션 시작점 파일 지정
		+ 예) `src/main.js`
	2.  **Module**: JS, Vue, CSS 등 파일을 처리할 **로더(loader)** 지정
		+  **module.rules**: 특정 파일을 어떻게 처리할지 정의 (파일 단위 처리)
		+ 예시
		```
	module: {
	    rules: [
	        {   // vue 파일은 이제 vue-loader 가 처리함
	            test: /\.vue$/,
	            loader: 'vue-loader'
	        },
	        {
	            test: /\.js$/,
	            exclude: /node_modules/,
	            loader: 'babel-loader'
	        },
	        {
	            test: /\.css$/,
	            use: ['style-loader', 'css-loader']
	        },
	    ]
	},
	```

3.  **Plugins** : 빌드 과정 전반을 제어하거나 추가 기능 수행

4.  **Output**: 번들링 후 결과물 저장

##  ✅ 명령어 정리

```bash

# 프로젝트 초기화 (package.json 생성)

npm  init

# 외부 라이브러리 설치

npm  install  numberbaseball

# Vue 설치

npm  install  vue

  

# 웹팩 설치

npm  install  webpack  webpack-cli  -D

  

# Vue 파일(.vue) 처리를 위한 vue-loader 설치 - Vue 3버전

npm  install  -D  vue-loader@next  @vue/compiler-sfc

```

  

##  ✅ NPM(Node Package Manager)

+ 남이 만든 패키지(소스 코드)를 쉽게 설치하고 관리할 수 있는 도구 이다.

+ 설치한 패키지는 **package.json 의존성 목록 + node_modules 실제 코드**로 관리된다.

  

##  ✅ node_modules

+  **실제 패키지 소스 코드들이 설치되는 폴더 이다.**

+ Git에는 올리지 않고 package.json + package-lock.json으로 관리한다.

  

##  ✅ package.json

+  **프로젝트 메타 정보, 의존성, 스크립트** 등이 기록된 파일 이다.

+ 팀원이나 다른 환경에서 `npm install` 시 package.json을 기반으로 필요한 패키지 설치 가능