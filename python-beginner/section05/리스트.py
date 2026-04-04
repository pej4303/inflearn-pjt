# 리스트 : 중복 허용, 순서가 있음
list = [10, '안녕', True]
print(list)

subway = ['유재석', '조세호', '박명수']
print(subway)

print(subway.index('조세호'))

# 리스트 추가
subway.append('하하')
print(subway)

# 리스트 중간에 추가
subway.insert(1, '정형돈')
print(subway)

# 리스트 삭제
subway.pop()
print(subway)

subway.append('유재석')
print(subway.count('유재석'))

# 리스트 정렬
num_list = [3,5,2,6]
num_list.sort()
print(num_list)

# 순서 뒤집기
num_list.reverse()
print(num_list)

# 리스트 지우기
# num_list.clear()
# print(num_list)

num_list.extend(list)
print(num_list)