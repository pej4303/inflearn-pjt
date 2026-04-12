class VietnamPackage:
    def detail(self):
        print('[베트남 패키지 3박 5일] 다낭 효도 여행 70만원')

if __name__ == '__main__':
    print('VietnamPackage 모듈을 직접 실행')
    print('이 문장은 모듈을 직접 실행할 때만 실행된다.')

    trip = VietnamPackage()
    trip.detail()
else:
    print('VietnamPackage 외부에서 모듈 호출')