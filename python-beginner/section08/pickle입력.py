# pickle : 파이썬 객체를 그대로 파일로 저장,복원할 때 사용하는 라이브러리
import pickle
'''
# 파일 생성
# wb = write binary (바이너리 쓰기 모드)
# pickle은 바이너리 형태로 저장하기 때문에 꼭 b 붙여야 한다.
profile_file = open('profile.pickle', 'wb')

profile = {
    '이름': '테스트',
    '나이': 20,
    '취미': ['누워있기', '유투브', '코딩']
}

# 파일 저장
pickle.dump(profile, profile_file) # profile에 있는 정보를 파일에 저장

profile_file.close()
'''

'''
# with 사용
profile = {
    '이름': '테스트',
    '나이': 20,
    '취미': ['누워있기', '유투브', '코딩']
}

with open('profile.pickle', 'wb') as profile_file:
    pickle.dump(profile, profile_file)
'''

# json 파일로 저장하기
import json

jsonTest = {
    '이름': '테스트',
    '나이': 20,
    '취미': ['누워있기', '유투브', '코딩']
}

with open('fileTest.json', 'w', encoding='utf-8') as file:
    json.dump(jsonTest, file, ensure_ascii=False, indent=4)
