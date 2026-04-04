# 문자열처리함수
str = 'Python is Amazing'
print(str.lower())  # 모두 소문자로 변경
print(str.upper())  # 모두 대문자로 변경

print(len(str))
print(str[0].isupper())

# 문자열 변경
print(str.replace('Python', 'Java'))

# find => 못 찾으면 -1
print(str.find('Java'))

# index => 못 찾으면 오류를 낸다.
# print(str.index('Java'))

# 'n'이 몇번 나오는지
print(str.count('n'))