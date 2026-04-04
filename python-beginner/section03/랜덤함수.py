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