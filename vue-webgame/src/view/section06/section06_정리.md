## ✅ props
+ 읽기 전용 데이터
+ 부모 컴포넌트 -> 자식 컴포넌트로 데이터를 전송할 때 사용함
+ 부모가 바꾸면 자식도 자동으로 업데이트됨
```
<LottoBall :number="num" />

props: {
  number: Number
}
```
## ✅ watch
+ 값이 바뀔 때 **부수효과(side effect)**를 실행할 때만 사용
+ 단순 계산은 computed로 대체 가능
+ 남용하면 코드가 복잡하고 유지보수 어려워지기 때문에 **되도록이면 사용하지 말것**
```
watch(() => props.number, (newVal) => {
  // 단순 계산만 하는 경우 -> computed로 바꾸는 게 낫다
})
```