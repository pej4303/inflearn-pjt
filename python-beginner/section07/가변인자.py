# 가변인자 :  '*'로 해서 가변인자를 사용 할 수 있음
def profile(name, age, *language):
    print('이름 : {0}\t 나이 : {1}\t'.format(name, age))
    for lang in language:
        # end : 줄바꿈 대신 할거
        print(lang, end=' ')
    print()

profile('테스트1', 20, '파이썬', '자바', 'C')
profile('테스트2', 30, '자바')

