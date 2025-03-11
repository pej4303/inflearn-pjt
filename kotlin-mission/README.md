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
    + 사용자(TB_USER)
    + 공통코드(TB_CODE)

## 📝 API

### 1️⃣ 주문 조회 
+ **URL:** `GET /order`
+ **설명:** 기간내에 있는 주문을 조회하거나 특정 주문을 조회합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | String | 선택     | 주문번호 |
  | `startDt` | String | 필수     | 주문 시작일자  |
  | `endDt` | String | 선택     | 주문 종료일자(기본값: 현재일자)|
+ **Request Body:**
  ```json
  {
    "orderList": [
      {
        "orderNo": 1,
        "orderLineNo": "001",
        "orderSts": 10,
        "userId": "U001",
        "productCd": "10000",
        "productNm": "테스트상품명1",
        "price": 10000,
        "qty": 1,
        "vat": 1000,
        "totalPrice": 11000,
        "createdDt": "2024-03-11T12:00:00Z",
        "createdBy": "admin",
        "updatedAt": "2024-03-11T12:00:00Z"
        "updatedBy": "admin",
        "delYn": "N",
        "memo": "테스트주문1"
      },
      {
        "orderNo": 1,
        "orderLineNo": "001",
        "orderSts": 10,
        "userId": "U001",
        "productCd": "10001",
        "productNm": "테스트상품명2",
        "price": 10000,
        "qty": 1,
        "vat": 1000,
        "totalPrice": 11000,
        "createdDt": "2024-03-11T12:00:00Z",
        "createdBy": "admin",
        "updatedAt": "2024-03-11T12:00:00Z"
        "updatedBy": "admin",
        "delYn": "N",
        "memo": "테스트주문2"
      }
    ]
  }
  ```
### 2️⃣ 주문 등록
+ **URL :** `POST/order`
+ **설명:** 주문을 등록합니다.
+ **Request Body:**
    ```json
    {
      "userId": "U001",
      "items": [
        {
          "productCd": 10000,
          "price": 10000,
          "qty": 1,
          "memo": "테스트주문1"
        },
        {
          "productCd": 10001,
          "price": 10000,
          "qty": 1,
          "memo": "테스트주문2"
        }
      ]
    }
    ```
+ **Response Body:**
    ```json
    {
      "code": 200,
      "msg": "주문 등록 성공",
      "orderNo": 1,
      "orderSts": "10"
    }
    
    {
      "code": 400,
      "msg": "요청 데이터 오류",
      "orderNo": "",
      "orderSts": ""
    }
    ```
### 3️⃣ 주문 수정
+ **URL :** `PUT /order`
+ **설명:** 특정 주문을 수정합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | String | 필수     | 주문번호 |
  | `items` | Array | 필수     | 변경할 주문정보들(상품코드, 가격, 수량, 메모)  |
+ **Request Body:**
    ```json
    {
      "orderNo": 1,
      "items": [
        {
          "productCd": 10000,
          "price": 10000,
          "qty": 2,
          "memo": "테스트주문1"
        },
        {
          "productCd": 10001,
          "price": 10000,
          "qty": 2,
          "memo": "테스트주문2"
        }
      ]
    }
    ```
+ **Response Body:**
    ```json
    {
      "code": 200,
      "msg": "주문 수정 성공",
      "orderNo": 1,
      "orderSts": "10"
    }
    
    {
      "code": 404,
      "msg": "해당 주문번호의 정보가 존재하지 않습니다.",
      "orderNo": "",
      "orderSts": ""
    }
    
    {
      "code": 400,
      "msg": "배송완료 상태여서 변경할 수 없습니다.",
      "orderNo": "1",
      "orderSts": "60"
    }
    ```

### 4️⃣ 주문 삭제
+ **URL :** `DELETE /order/{orderNo}`
+ **설명:** 특정 주문을 삭제합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | String | 필수     | 주문번호 |
+ **Request Body:**
    ```json
    {
      "orderNo": 1
    }
    ```
+ **Response Body:**
    ```json
    {
      "code": 200,
      "msg": "주문 삭제 성공",
      "orderNo": 1,
      "orderSts": "0"
    }
    
    {
      "code": 404,
      "msg": "해당 주문번호의 정보가 존재하지 않습니다.",
      "orderNo": "",
      "orderSts": ""
    }
    
    {
      "code": 400,
      "msg": "배송완료 상태여서 변경할 수 없습니다.",
      "orderNo": "1",
      "orderSts": "60"
    }
    ```
