# 연산자
print(1+1) # 2
print(3-2) # 1
print(5*2) # 10
print(6/3) # 2.0
print(2**3) #  2^3 = 8
print(5%3) # 나머지 구하기 2
print(5//3) # 몫 구하기 1
print(not(1 != 3)) # False
print(5 > 4 > 3) # True

# 숫자처리함수
print(abs(-5)) # 5
print(pow(4, 2)) # 4^2 = 16
print(max(5, 12)) # 12
print(min(5, 12)) # 5
print(round(3.14)) # 3
print(round(4.99)) # 5

# 라이브러리
from math import *

print(floor(4.99)) # 4
print(ceil(3.14)) # 4
print(sqrt(16)) # 4

# 랜덤함수
from random import *
print(random()) # 0.0 ~ 1.0 미만의 임의의 값 생성   

'''
randint(a, b)는 a와 b 모두 포함해서 그 사이의 정수를 뽑는다. 
randrange(a, b)는 a부터 (b-1)까지, 즉 b는 포함하지 않고 뽑는다.
'''
print(randrange(1, 10)) # 1 ~ 10 미만의 임의의 값 생성
print(int(random() * 10) + 1) # 1 ~ 10 이하의 임의의 값 생성
print(int(random() * 45) + 1) # 1 ~ 45 이하의 임의의 값 생성
print(randint(1, 45)) # 1 ~ 45 이하의 임의의 값 생성