'''
퀴즈) 당신의 회사에서는 매주 1회 작성해야 되는 보고서가 있습니다.
보고서는 항상 아래와 같은 형태로 출력되어야 합니다.

1주차부터 50주차까지의 보고서 파일을 만드는 프로그램을 작성하시오.

- 조건 : 파일명은 '1주차.txt', '2주차.txt', ... 와 같이 만듭니다.

(출력예제)
- X주차 주간보고 -
부서 :
이름 :
업무 요약 :
'''

for week in range(1, 51):
    # print(week)
    
    # 파일명
    file_name = str(week) + '주차.txt'
    
    with open(file_name, 'w', encoding='utf-8') as week_file:
        week_file.write('부서 : \n')
        week_file.write('이름 : \n')
        week_file.write('업무요약 : \n')
        