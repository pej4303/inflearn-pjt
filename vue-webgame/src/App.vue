<template>
  <div>
    <nav>
      <router-link to="/">홈</router-link>|
      <router-link to="/section03">숫자 야구</router-link>|
      <router-link to="/section04">반응속도 체크</router-link>|
      <router-link to="/section05">가위바위보</router-link>|
      <router-link to="/section06">로또번호 추첨기</router-link>|
      <router-link to="/section07">틱택토</router-link>|
      <router-link to="/section08">지뢰찾기</router-link>|
    </nav>
    <hr/>
    <router-view />
  </div>
</template>