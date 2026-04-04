# 방법1
print('나는 %d살입니다.' % 20)
print('나는 %s를 좋아합니다.' % '파이썬')

# 방법2 순번
print('나는 {}살입니다.'.format(20))
print('나는 {0}살이고, {1}을 좋아합니다.'.format('20', '파이썬'))

# 방법3 변수
print('나는 {age}살이고, {like}을 좋아합니다.'.format(age = 20, like = '파이썬'))

# 방법4 (v3.6 이상)
age = 20
like = '파이썬'
print(f'나는 {age}살이고, {like}을 좋아합니다.')