# encoding 없으면 한글 깨짐
# w : 덮어쓰기가 됨
score_file = open('score.txt', 'w', encoding='utf-8')

print('국어 : 90', file=score_file)
print('수학 : 85', file=score_file)
print('영어 : 80', file=score_file)

# 파일은 항상 닫아줘야 한다.
score_file.close()

# a : 추가
score_file = open('score.txt', 'a', encoding='utf-8')
# 내용 추가
score_file.write('과학 : 70\n')
score_file.write('사회 : 70\n')
# 파일 닫기
score_file.close()