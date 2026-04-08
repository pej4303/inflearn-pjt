'''
퀴즈) 표준 체중을 구하는 프로그램을 작성하시오
* 표준 체중 : 각 개인의 키에 적당한 체중
* 성별에 따른 공식
남자 : 키(m) X 키(m) X 22
여자 : 키(m) X 키(m) X 21

조건1 : 표준 체중은 별도의 함수 내에서 계산
- 함수명 : std_weight
- 전달값 : 키(height), 성별(gender)
조건2 : 표준 체중은 소수점 둘째자리까지 표시

(출력예제)
키 175cm 남자의 표준 체중은 67.38kg 입니다.
'''
def std_weight(height:int, gender:int):
    if gender != 1 and gender != 2:
        print('성별은 1 또는 2로 입력해주세요.')
        return

    # 남자
    if gender == 1:
        strGender = '남자'
        weight = round( (height / 100) * (height / 100) * 22, 2)
    # 여자
    else:
        strGender = '여자'
        weight = round( (height / 100) * (height / 100) * 21, 2)
    # print(weight)
    print(f'키 {height}cm {strGender}의 표준 체중은 {weight}kg 입니다.')

std_weight(175, 1)