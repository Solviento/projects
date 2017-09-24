# locate_object.py
import time
import math
from gopigo import *
from time import sleep

# adjust sonic sensor servo with added offset bias (vals: 0-90-180)
servo_pos = 78
servo(servo_pos)

#adjust motor speed (no units)
set_speed(50)

# Turn until object seen
while True:
	# sets wheel encoder, third parameter = pulses (32 pulses ~ 1 wheel rotation)
    enc_tgt(1, 0, 1)
    # stores ultrasonic sensor current recorded distance
    dist = us_dist(15)
    set_speed(50)
    # rotate left continuously using an encoder target
    left_rot()
    # print ultrasonic distance for debugging purposes
    print(dist)
    # sleep for one second so that robot has time to carry out commands
    sleep(1)
    # sensor has located object within 120 cm (adjusted for 1m)
    if(dist < 120):
        break
    
sleep(1)
print('found obj!')
# we keep track of pulse count to know how many pulses the object
# requires to fully cover using the sensor's conical beam
pulse_count = 0

# Keep turning until object no longer seen
while True:
	enc_tgt(1, 0, 1)
    left_rot()
    
    pulse_count += 1
    dist = us_dist(15)
    print('Pulses: ' + str(pulse_count * 1)) 
    print(dist)
    # once object is no longer in view of sonic sensor, we turn back
    if (dist > 120):
        break
    sleep(1)
    
print('Turning back...')
sleep(1)
# will rotate using specific number of pulses based on how wide the object is
enc_tgt(1, 0, 1+int(math.ceil(float(pulse_count)/2)))
right_rot()

sleep(1)

# move forward in 1 pulse rotations until sensor confirms we are 55 cm away
while True:
    dist = us_dist(15)
    enc_tgt(1, 0, 1)
    forward()
    print(dist)
	# after many runs, we see that the robot is guaranteed to veer away
	# from the object, therefore we reset the robot's local frame
    if (dist < 55):
        print(dist)
        stop()
        break
    sleep(1)

sleep(1)

# reconfigure encoder target so that robot's sensor is reset once we rotate
# in order to locate the object again
enc_tgt(1, 0, 5)
right_rot()

sleep(1)

# Turn until object seen
while True:
    enc_tgt(1, 0, 1)
    dist = us_dist(15)
    set_speed(50)
    left_rot()
    print(dist)
    sleep(1)
    if(dist < 80):
        break

sleep(1)
print('found obj!')
pulse_count = 0

while True:
    enc_tgt(1, 0, 1)
    left_rot()
    pulse_count += 1
    dist = us_dist(15)
    print('Pulses: ' + str(pulse_count * 1)) 
    print(dist)
    # sensor is out of range with object, turn back
    if (dist > 80):
        break
    sleep(1)
    
print('Turning back...')
sleep(1)
# adding +1 to take into account the right side bias
enc_tgt(1, 0, 1+int(math.ceil(float(pulse_count)/2)))
right_rot()

sleep(1)

# move forward until robot is 20cm away from object
while True:
    dist = us_dist(15)
    enc_tgt(1, 0, 1)
    forward()
    if(dist<20):
        stop()
        break
    
