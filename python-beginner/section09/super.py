class Unit:
    def __init__(self):
        print('Unit 클래스 생성자')
class Flyable:
    def __init__(self):
        print('Flyable 클래스 생성자')
class FlyableUnit(Flyable, Unit):
    def __init__(self):
        # super().__init__() # => Flyable 클래스의 생성자만 호출됨
        
        # 다중상속시에는 이렇게 따로 호출해줘야 한다.
        Unit.__init__(self)
        Flyable.__init__(self)


dropShip = FlyableUnit()