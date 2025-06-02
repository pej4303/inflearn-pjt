# 📌 프로젝트명

> 스프링부트로 직접 만들면서 배우는 대규모 시스템 설계 - 게시판
---

## 📂 프로젝트 구조

```bash
kuke-board/  
├── common/               # 공통 모듈 (유틸, 공통 로직 등) 
└── service/              # 비즈니스 도메인 서비스 모듈  
	├── article/          # 게시글
	├── article-read/     # 게시글 조회  
	├── comment/          # 댓글  
	├── hot-article/      # 인기글 
	├── like/             # 좋아요  
	└── view/             # 조회수
└── README.md             # 리드미 파일
```

### 🧩 멀티 모듈 구성
- `allprojects {}` 블록을 통해 공통 설정 적용 중
- 멀티 모듈 프로젝트에 맞춘 플러그인 및 의존성 구조 설정됨

## 🚀 기술 스택

### Backend
+ Java 21
+ Spring Boot 3.4.5
+ Spring Data JPA

### Database
+ Oracle 21c
+ Redis

### Test
+ JUnit 5 (with Spring Boot Test)

### Infra & DevOps
+ Docker

### ETC & Tools
+ Lombok
+ IntelliJ IDEA 2025.1.1.1
+ Snowflake ID Generator (분산 ID 생성)
+ Jasypt (환경 변수 암호화)
---
