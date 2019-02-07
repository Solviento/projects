from gopigo import *
from time import sleep

'''Calculates and prints out the beam width.

Set GoPiGo down facing roughly toward the Ben's water 
bottle set 100cm away'''

servo_pos=0

servo(servo_pos)
sleep(1)

has_seen = False
has_seen_twice = False
ct = 0

objdetect = 0
objnoshow = 0

while True:
	
	# search, detect object, once detected - recor the servo angle
	# keep sensor servo moving until object is no longer in view
	# compute then store measured beam width
	
    servo(servo_pos)
    
    # continuously increment servo angle
    servo_pos += 1
    sleep(.5)
    dist = us_dist(15)
    
    print("distance: " + str(dist))
    print('servo pos ' + str(servo_pos))
    
    if (dist <= 120 and not has_seen):
		has_seen = True
		objdetect = servo_pos
		ct += 1
		
    elif(dist <= 120 and has_seen):
		ct += 1
		
		
    elif (dist > 120 and has_seen and ct > 3):
		objnoshow = servo_pos
		beamwidth = objnoshow - objdetect
		
		# Subtract 3 for angle of bottle (asin(6cm / 100cm) = 3.4 deg)
		print('beam width ' + str(beamwidth - 3))
		break
