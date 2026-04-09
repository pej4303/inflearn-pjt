import pickle

'''
# 파일 읽어오기
profile_file = open('profile.pickle', 'rb')

# 파일에 있는 정보를 불러오기기
profile = pickle.load(profile_file)
print(profile)

# 파일 닫기
profile_file.close()
'''

# with 사용 : 자동으로 파일 닫힘 (close() 안 써도 됨)
with open('profile.pickle', 'rb') as profile_file:
    # 파일에 있는 정보를 불러오기기
    print(pickle.load(profile_file))

import json

with open('fileTest.json', 'r', encoding='utf-8') as file:
    profile = json.load(file)

print(profile)