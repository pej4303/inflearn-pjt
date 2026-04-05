# 함수 생성
def open_account():
    print('새로운 계좌가 생성되었습니다.')

# 입금
def deposit(balance, money):
    print(f'입금이 완료되었습니다. 잔액은 {balance + money}원 입니다.')
    return balance + money

# 출금
def withdraw(balance, money):
    if (balance >= money):
        print(f'출금이 완료되었습니다. 잔액은 {balance - money}원 입니다.')
        return balance - money
    else:
        print(f'출금이 불가합니다. 잔액은 {balance}원 입니다.')
        return balance
# 출금
def withdraw_night(balance, money):
    commission = 100 # 수수료
    return commission, balance - money - commission
    
# 함수 호출
balance = 0

open_account()
balance = deposit(balance, 1000)
# balance = withdraw(balance, 500)
commission, balance = withdraw_night(balance, 500)
print(f'수수료는 {commission}원이며, 잔액은 {balance}원입니다.')