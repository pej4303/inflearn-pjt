nick_name = '토르'
index = 5
while index >= 1:
    print(f'{nick_name}, 커피가 준비되었습니다. {index}번 남았어요.')
    index -= 1
    if index == 0:
        print('커피는 폐기처분되었습니다.')