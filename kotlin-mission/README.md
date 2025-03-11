# kotlin-mission
인프런 워밍업 클럽 3기 백엔드 과제 리포지토리

## 🚀 과제 개요
+ 주제 : 주문 관리 시스템

## 🛠️ ERD 및 테이블 설계
+ ERD
![ERD](https://private-user-images.githubusercontent.com/48613952/420672754-b807bf63-5f9f-4c54-adff-b04c7f8ff9d2.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDE1MjU2MTMsIm5iZiI6MTc0MTUyNTMxMywicGF0aCI6Ii80ODYxMzk1Mi80MjA2NzI3NTQtYjgwN2JmNjMtNWY5Zi00YzU0LWFkZmYtYjA0YzdmOGZmOWQyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTAzMDklMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwMzA5VDEzMDE1M1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTljMDJiNDE1YjU5N2FkMGRkODMzOTlhZDNjNmRhNjMwNTY0MjUyZTE2ZTk5NTJjMDQxY2NkMTg0NDNlZjliZDAmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.AHK7XLxqSOEP1DTyXYWHadgewrbEiqrv7blpD_D8qtM)
+ 테이블 목록
    + 주문(TB_ORDER)
    + 주문상세(TB_ORDER_DETAIL)
    + 상품(TB_PRODUCT)
    + 거래처(TB_COMPANY)
    + 사용자(TB_USER)
    + 공통코드(TB_CODE)

## 📝 API

### 1️⃣ 주문 조회 
+ **URL:** `GET /orders`
+ **설명:** 전체 주문 목록을 조회합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | String | 선택     | 주문번호 |
  | `startDt` | String | 필수     | 주문 시작일자  |
  | `endDt` | String | 선택     | 주문 종료일자(기본값: 현재일자)|

+ **Response Example:**
  ```json
  {
    "total": 2,
    "page": 1,
    "size": 10,
    "orders": [
      {
        "id": 1,
        "userId": 101,
        "totalPrice": 50000,
        "status": "CONFIRMED",
        "orderedAt": "2024-03-10T12:00:00Z"
      },
      {
        "id": 2,
        "userId": 102,
        "totalPrice": 75000,
        "status": "PENDING",
        "orderedAt": "2024-03-10T14:30:00Z"
      }
    ]
  }
  ```
  <!--
### 2️⃣ 주문 등록
+ **URL :** `POST/orders`
+ **설명:** 주문을 등록합니다.

### 3️⃣ 주문 수정
+ **URL :** `PUT /orders/{id}`
+ **설명:** 특정 주문을 수정합니다.

### 4️⃣ 주문 삭제
+ **URL :** `DELETE /orders/{id}`
+ **설명:** 특정 주문을 삭제합니다.
  -->
