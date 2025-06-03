# 📌 inflearn-pjt

> 인프런 강의를 바탕으로 작성한 소스코드 및 과제 프로젝트 모음집입니다.

## 📂 프로젝트 추가 방법

### 1. 서브 프로젝트용 레포지토리 생성
- GitHub 등에서 새로운 프로젝트 레포지토리를 생성합니다.

### 2. 메인 레포지토리에 서브트리로 추가
```bash
git subtree add --prefix=프로젝트명 https://github.com/pej4303/프로젝트.git main --squash
git add .
git commit -m "프로젝트 추가: 프로젝트명"
git push origin main
```

### ✅ 설명 보충
- `--prefix`는 해당 프로젝트를 이 레포지토리 내의 서브 디렉토리로 추가하는 옵션입니다.
- `--squash`는 기존 커밋 히스토리를 하나로 합쳐서 추가합니다.

---
