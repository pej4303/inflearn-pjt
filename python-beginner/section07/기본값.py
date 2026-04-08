def profile(name, age = 17, main_lang = '파이썬'):
    print(f'이름 : {name} \t 나이 : {age} \t 주 사용 언어 : {main_lang}')


profile('나도코딩', 23, '파이썬')
# 기본값이 나옴
profile('나도코딩2')

# 이렇게 변수에 직접 값을 넣어도 된다.
profile(name = 'pej', age = 34, main_lang = '자바')
