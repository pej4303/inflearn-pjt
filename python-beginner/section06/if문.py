weather = input('오늘 날씨는 어때요?')
if weather == '비' or weather == '눈눈':
    print('{0}을 챙기세요'.format('우산'))
elif weather == '미세먼지':
    print('{0}을 챙기세요'.format('마스크'))
else:
    print('좋은 날씨')
