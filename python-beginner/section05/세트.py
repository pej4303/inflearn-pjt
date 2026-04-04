# 세트 : 중복이 안되고 순서가 없음
my_set = {1,3,5,6,3,3,3}
print(my_set) # {1, 3, 5, 6} => 중복 허용 X

java = {'유재석', '김태호', '양세형'}
python = set(['유재석', '박명수'])

# 교집합
print(java & python)
# print(java.intersection(python))

# 합집합
print(java | python)
# print(java.union(python))

# 차집합 자바는 할 수 알지만 파이썬을 할줄 모르는 사람
print(java - python)
# print(java.difference(python))

# 항목 추가 및 삭제
python.add('김태호')
java.remove('김태호')