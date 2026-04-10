# 클래스 생성
class Unit:
    tmp = '멤버변수나오지'    # 멤버변수

    '''
    __init__ : 
        - 파이썬에서 클래스의 생성자이다. 
        - 클래스의 인스턴스를 생성할 때 자동으로 호출되며 인스턴스가 생성될 때 초기화 작업을 수행한다.
        - 첫번째 매개변수로 self를 사용한다.
    self:
        - 자바의 this를 의미한다.
        - 클래스 함수의 첫번째 매개변수를 반드시 self여야 한다.
    '''
    def __init__(self, name, hp):
        self.name = name
        self.hp = hp

    def printUnit(self):
        print(f'{self.name} 유닛이 생성 되었습니다.')

# Unit 클래스 상속 받음
class AttackUnit(Unit):
# class AttackUnit(Unit, Unit2): # 이렇게 하면 다중 상속도 가능함
    def __init__(self, name, hp, damage):
        # 이렇게 사용해도 됨
        # Unit.__init__(self, name, hp)
        super().__init__(name, hp)
        self.damage = damage
    
    def printUnit(self):
        print(f'{self.name} 유닛이 생성 되었습니다.')
        print(f'체력: {self.hp} / 공격력: {self.damage}')

    def attack(self, location):
        print(f'{self.name} : {location} 방향으로 공격을 합니다. [공격력 {self.damage}]')

    def damaged(self, damage):
        print(f'{self.name} : {damage} 데미지를 입었습니다.')
        self.hp -= damage
        print(f'{self.name} : 현재 체력은 {self.hp} 입니다.')

        if self.hp <= 0:
            print(f'{self.name} : 파괴되었습니다.')

class BuildingUnit(Unit):
    def __init__(self, name, hp, location):
        # 아무것도 안 하고 그냥 넘어가라, 함수 뼈대 만들때 사용한다.
        pass 
    
unit1 = Unit('마린', 40)
unit1.printUnit()

unit2 = AttackUnit('탱크', 150, 55)
unit2.printUnit()

# print(f'인스턴스 변수 출력 :: unit2.name = {unit2.name}')
# print(f'멤버버 변수 출력 :: unit2.tmp = {unit2.tmp}')

# firebat = AttackUnit('파이버뱃1', 50, 16)
# firebat.attack('5시')
# firebat.damaged(25)
# firebat.damaged(25)

unit3 = BuildingUnit('서플라이 유닛', 500, '7시')