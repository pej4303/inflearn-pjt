menu = {'커피', '우유', '주스'}

# ['커피', '주스', '우유'] <class 'list'>
menu = list(menu)
print(menu, type(menu))

# ('커피', '주스', '우유') <class 'tuple'>
menu = tuple(menu)
print(menu, type(menu))

# {'커피', '주스', '우유'} <class 'set'>
menu = set(menu)
print(menu, type(menu))
