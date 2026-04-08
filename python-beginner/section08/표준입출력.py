# 가vs나vs다
print('가', '나', '다', sep='vs')

# import sys
# print('Python', 'Java', file=sys.stdout)
# 표준 에러로 출력
# print('Python', 'Java', file=sys.stderr)

# 정렬
scores = {'수학': 70, '영어': 80, '국어': 100}
for subject, score in scores.items():
    # print(subject, score)
    # 과목은 좌측정렬, 점수는 우측정렬
    print(subject.ljust(8), str(score).rjust(4), sep=':')

# 대기순번표
for num in range(1, 21):
    # 001, 002 순으로 나옴
    print(f'대기번호 : {str(num).zfill(3)}')