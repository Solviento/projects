from gopigo import *
from time import sleep

'''Calculates the beam width.

Set up the GoPiGo so that its sensor is less than 60 centimeters away from a single object
at a direct 90 degree angle left of the sensor.'''

servo_pos=78

servo(servo_pos)
sleep(1)

while True:
    servo(servo_pos)
    servo_pos += 1
    sleep(.5)
    dist = us_dist(15)
    print("distance: " + str(dist))
    if(dist < 60):
        print('Beam width: ' + str(2 * (180 - servo_pos)))
        break
