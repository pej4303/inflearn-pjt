# 방법1)
'''
import travel.japan

trip1 = travel.japan.JapanPackage()
trip1.detail()
'''

# 방법2)
'''
from travel.japan import JapanPackage

trip1 = JapanPackage()
trip1.detail()
'''

# all
from travel import *
trip1 = vietnam.VietnamPackage()
trip1.detail()

trip2 = japan.JapanPackage()
trip2.detail()