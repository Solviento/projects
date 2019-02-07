from gopigo import *
from time import sleep
import random

''' Tells GoPiGo to move around in random directions for ~20 seconds '''

for i in range(20):

    rand = random.randint(1, 4)

    if rand == 1:
        fwd()
    elif rand == 2:
        bwd()
    elif rand == 3:
        left()
    else:
        right()

    sleep(1)

stop()
