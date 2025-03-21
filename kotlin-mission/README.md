# kotlin-mission
인프런 워밍업 클럽 3기 백엔드 과제 리포지토리

![이미지](https://private-user-images.githubusercontent.com/48613952/421873869-115b710a-ba79-47d9-9e23-82ac9c94c300.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDE3ODE1MDcsIm5iZiI6MTc0MTc4MTIwNywicGF0aCI6Ii80ODYxMzk1Mi80MjE4NzM4NjktMTE1YjcxMGEtYmE3OS00N2Q5LTllMjMtODJhYzljOTRjMzAwLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTAzMTIlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwMzEyVDEyMDY0N1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWM1MjIzYjdjZGVhZDdmMmIyNDE3MjE0OGM2OTc0OTY5NTBiMjlhZGFmNmI5NTNiNmY4MGM3OGYzM2I0YjA0YzcmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.OkvBAwERyHd4xgyKcYr3H0HaNgEBYenOlN6ez7UXGJQ)

## 🚀 과제 개요
+ 주제 : 주문 관리 시스템

## 🛠️ ERD 및 테이블 설계
![ERD](https://cdn.inflearn.com/public/files/posts/47c53bd5-8227-4314-b94e-ab62ba75bcd2/efc5a91c-3c59-4137-89cd-2b57aae5294c.png)
+ 테이블 목록
    + `TB_ORDER`(주문) : 주문 마스터 정보를 저장하는 테이블
    + `TB_ORDER_DETAIL`(주문 상세) : 주문 상세 정보를 저장하는 테이블
    + `TB_PRODUCT`(상품) : 상품 정보를 저장하는 테이블

## 📝 API

### 1️⃣ 주문 조회 
+ **URL:** `GET /order`
+ **설명:** 특정 주문을 조회합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | Long | 필수     | 주문번호 |
+ **Response Body:**
  ```json
  {
    "orderList": [
      {
        "orderNo": 1,
        "orderLineNo": "001",
        "orderSts": 10,
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
        "memo": "테스트주문1"
      },
      {
        "orderNo": 1,
        "orderLineNo": "001",
        "orderSts": 10,
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
      "msg": "해당 상품코드가 없습니다. [상품코드 : 1]",
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
  | `orderNo`   Long | 필수     | 주문번호 |
  | `items` | Array | 필수     | 변경할 주문정보들(상품코드, 가격, 수량, 메모, 주문상태)  |
+ **Request Body:**
    ```json
    {
      "orderNo": 1,
      "items": [
        {
          "productCd": 10000,
          "price": 10000,
          "qty": 2,
          "memo": "테스트주문1",
          "orderSts": 60
        },
        {
          "productCd": 10001,
          "price": 10000,
          "qty": 2,
          "memo": "테스트주문2",
          "orderSts": 60
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
      "code": 400,
      "msg": "해당 상품코드가 없습니다. [상품코드 : 1]",
      "orderNo": "",
      "orderSts": ""
    }
    
    {
      "code": 400,
      "msg": "유효하지 않은 주문 상태 코드입니다. [주문상태 : 1]",
      "orderNo": "",
      "orderSts": ""
    }

    {
      "code": 400,
      "msg": "배송완료 상태는 수정 할 수 없습니다. [주문번호 : 1]",
      "orderNo": "",
      "orderSts": ""
    }
    ```

### 4️⃣ 주문 삭제
+ **URL :** `DELETE /order/{orderNo}`
+ **설명:** 특정 주문을 삭제합니다.
+ **Request Parameters:**
  | 이름      | 타입    | 필수 여부 | 설명                    |
  |----------|--------|----------|------------------------|
  | `orderNo`   | Long | 필수     | 주문번호 |
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
      "orderSts": ""
    }
    
    {
      "code": 400,
      "msg": "해당 주문정보가 없습니다. [주문번호 : 10000]",
      "orderNo": "",
      "orderSts": ""
    }
    
    {
      "code": 400,
      "msg": "배송완료 상태는 삭제 할 수 없습니다. [주문번호 : 1]",
      "orderNo": "",
      "orderSts": ""
    }
    ```
