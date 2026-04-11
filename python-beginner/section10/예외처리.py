class NumberError(Exception):
    def __init__(self, msg) -> None:
        self.msg = msg

    # __str__ :  print(e) 했을 때 메시지가 나오게 설정
    def __str__(self) -> str:
        return self.msg

try:
    num1 = int(input('첫번째 숫자를 입력하세요 : '))
    num2 = int(input('두번째 숫자를 입력하세요 : '))

    if num1 >= 10 or num2 >= 10:
        # 강제로 에러 발생시킴
        raise NumberError(f'입력값 : {num1}, {num2}')

    print(f'{num1} / {num2} = {int(num1 / num2)}')
except ValueError:
    print('에러!')
except ZeroDivisionError as err:
    # 에러 내용 출력
    print(err)
except NumberError as err:
    print('한 자리 숫자만 입력하세요.')
    print(err)
except Exception as err:
    print('에러!')
    print(err)
finally:
    print('계산기 종료')