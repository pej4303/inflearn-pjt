cabinet = {3:'유재석', 100:'김태호'}

# 대괄호로 가져오는 경우 값이 없을경우 프로그램이 종료된다.
print(cabinet.get(5)) # None

# 값이 없으면 디폴트값으로 출력됨
print(cabinet.get(5, '사용가능')) # 사용가능

# 해당 key가 있는지 확인
print(3 in cabinet) # True
print(5 in cabinet) # False

# key 추가
cabinet['C-20'] = '조세호'
print(cabinet)

# key 삭제
del cabinet['C-20']
print(cabinet)

# key만 출력
print(cabinet.keys())
# value만 출력
print(cabinet.values())
# key-value 형태로 출력
print(cabinet.items())

# 모두 삭제
cabinet.clear()
print(cabinet)