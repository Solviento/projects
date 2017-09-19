from gopigo import *
import time
from time import sleep
import math

servo_pos = 78

servo(servo_pos)
#sleep(5)

set_speed(50)
# enc_tgt(1, 0, 64)
# left()

# Turn until object seen
while True:
    enc_tgt(1, 0, 1)
    dist = us_dist(15)
    set_speed(50)
    left_rot()
    print(dist)
    sleep(1)
    if(dist < 120):
        break
    

sleep(1)

print('found obj!')
pulse_count = 0

# Keep turning until object no longer seen
while True:
    enc_tgt(1, 0, 1)
    left_rot()
    
    
    pulse_count += 1
    dist = us_dist(15)
    print('Pulses: ' + str(pulse_count * 1)) 
    print(dist)
    
    if (dist > 120):
        break
    sleep(1)
    
print('Turning back...')
sleep(1)
enc_tgt(1, 0, 1+int(math.ceil(float(pulse_count)/2)))
right_rot()

sleep(1)

while True:
    dist = us_dist(15)
    enc_tgt(1, 0, 1)
    forward()
    print(dist)
    if (dist < 55):
        print(dist)

        
        stop()
        break
    sleep(1)

sleep(1)

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
    
    if (dist > 80):
        break
    sleep(1)
    
print('Turning back...')
sleep(1)
enc_tgt(1, 0, 1+int(math.ceil(float(pulse_count)/2)))
right_rot()

sleep(1)

while True:
    dist = us_dist(15)
    enc_tgt(1, 0, 1)
    forward()
    if(dist<20):
        stop()
        break
    
