# 파일 읽어오기
score_file = open('score.txt', 'r', encoding='utf-8')

# 파일에 있는 모든 내용을 출력한다.
# print(score_file.read())

for line in score_file.readlines():
    print(line)

# 파일 닫기
score_file.close()