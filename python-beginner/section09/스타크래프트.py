class Unit:
    def __init__(self, name, hp, speed):
        self.name = name
        self.hp = hp
        self.speed = speed
        
        print(f'{self.name} 유닛이 생성 되었습니다.')

    def move(self, location):
        print(f'{self.name} : {location} 방향으로 이동합니다. [속도 {self.speed}]')
    def damaged(self, damage):
        print(f'{self.name} : {damage} 데미지를 입었습니다.')
        self.hp -= damage
        print(f'{self.name} : 현재 체력은 {self.hp} 입니다.')

        if self.hp <= 0:
            print(f'{self.name} : 파괴되었습니다.')

class AttackUnit(Unit):
    def __init__(self, name, hp, speed, damage):
        super().__init__(name, hp, speed)
        self.damage = damage
    
    def attack(self, location):
        print(f'{self.name} : {location} 방향으로 공격을 합니다. [공격력 {self.damage}]')

    def damaged(self, damage):
        self.hp -= damage
        print(f'{self.name} : {damage} 데미지를 입었습니다. [HP {self.hp}]')
        
        if self.hp <= 0:
            print(f'{self.name} : 파괴되었습니다.')

class Marine(AttackUnit):
    def __init__(self):
        super().__init__('마린', 40, 1, 5)
    
    # 스팀팩 : 일정 시간 동안 이동 및 공격 속도를 증가, 체력 10 감소
    def stimpack(self):
        if self.hp > 10:
            self.hp -= 10
            print(f'{self.name} : 스팀팩을 사용합니다. [HP {self.hp}]')
        else:
            print(f'{self.name} : 스팀팩을 사용 할 수 없습니다.')

class Tank(AttackUnit):
    # 시즈 모드 : 탱크를 지상에 고정시켜 더 높은 파워로 공격 가능, 이동 불가
    is_seize = False

    def __init__(self):
        super().__init__('탱크', 150, 1, 35)
        self.is_seize = False

    def set_seize_mode(self):
        # 시즈 모드 
        if self.is_seize == True:
            print(f'{self.name} : 시즈모드 해제합니다.')
            self.damage /= 2
            self.is_seize = False
        
        # 시즈 모드 아님
        else:   
            print(f'{self.name} : 시즈모드 작동합니다.')
            
            # 공격력 2배 증가
            self.damage *= 2
            self.is_seize = True

class Flyable:
    def __init__(self, flying_speed):
        self.flying_speed = flying_speed
    
    def fly(self, name, location):
        print(f'{name} : {location}방향으로 날아갑니다. [속도 {self.flying_speed}]')

class FlaybleAttackUint(AttackUnit, Flyable):
    def __init__(self, name, hp, damage, flying_speed):
        AttackUnit.__init__(self, name, hp, 0, damage) # 지상 스피드 0
        Flyable.__init__(self, flying_speed)
    
    def move(self, location):
        self.fly(self.name, location)

class Wraith(FlaybleAttackUint):
    def __init__(self):
        FlaybleAttackUint.__init__(self, '레이스', 80, 20, 5)
        self.is_clock = False
    
    def set_clock(self):
        if self.is_clock == True:
            print(f'{self.name} : 클로킹모드 해제합니다.')
            self.is_clock = False
        else:
            print(f'{self.name} : 클로킹모드 작동합니다.')
            self.is_clock = True

def game_start():
    print('[알림] 새로운 게임을 시작합니다.')
def game_over():
    print('Player : gg')
    print('[Player] 님이 퇴장하셨습니다.')

# 실제 게임 진행
from random import *

# 게임 시작
game_start()

# 마린 3개 생성
m1 = Marine()
m2 = Marine()
m3 = Marine()
# 탱크 2개 생성
t1 = Tank()
t2 = Tank()
# 레이스 1개 생성
w1 = Wraith()

# 유닛 일괄 관리
attck_unit_list = []
attck_unit_list.append(m1)
attck_unit_list.append(m2)
attck_unit_list.append(m3)
attck_unit_list.append(t1)
attck_unit_list.append(t2)
attck_unit_list.append(w1)

# 전군 이동
for unit in attck_unit_list:
    unit.move('1시')

Tank.is_seize = True

# 공격 모드 준비
for unit in attck_unit_list:
    # isinstance : 만들어진 객체가 어떤 클래스인지 확인
    if isinstance(unit, Marine):
        unit.stimpack()
    elif isinstance(unit, Tank):
        unit.set_seize_mode()
    elif isinstance(unit, Wraith):
        unit.set_clock()

# 전군 공격
for unit in attck_unit_list:
    unit.attack('1시')

# 전군 피해
for unit in attck_unit_list:
    # 공격은 랜덤으로 받음
    unit.damaged(randint(5, 21))

# 게임 종료
game_over()