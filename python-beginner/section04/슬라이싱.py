# 슬라이싱
jumin = '990101-2012345'

print('성별 = ' + jumin[9])

print('연도 = ' + jumin[0:2])   # 0 ~ 1까지
print('월 = ' + jumin[2:4])
print('일 = ' + jumin[4:6])

print('생년월일 = ' + jumin[:6])    # 0 ~ 5까지 
print('뒤 7자리 = ' + jumin[7:])
print('뒤 7자리 (뒤에서부터) = ' + jumin[-7:])