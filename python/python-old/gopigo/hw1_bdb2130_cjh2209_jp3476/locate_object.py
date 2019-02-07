# locate_object.py
import time
import math
from gopigo import *
from time import sleep

'''Locates and approaches an object 1 meter behind the GoPiGo'''

# adjust sonic sensor servor with added offset bias (vals: 0-90-180)
servo_pos = 80
servo(servo_pos)

#adjust motor speed (no units)
set_speed(50)


def search_and_dest(to_distance, final):

	# Turn until object seen
	while True:
		# sets wheel encoder, third parameter = pulses (32 pulses ~ 1 wheel rotation)
		enc_tgt(0, 1, 1)
		# rotate left continuously using an encoder target
		left()
		# sleep for one second so that robot has time to carry out commands
		sleep(1)
		# stores ultrasonic sensor current recorded distance
		dist = us_dist(15)
		# print ultrasonic distance for debugging purposes
		print(dist)
		
		# sensor has located object within 120 cm (adjusted for 1m)
		if(dist < 140):
			break
		
	sleep(1)
	print('found obj!')
	# we keep track of pulse count to know how many pulses the object
	# requires to fully cover using the sensor's conical beam
	pulse_count = 0

	# Keep turning until object no longer seen
	while True:
		enc_tgt(0, 1, 1)
		left()
		sleep(1)
		
		pulse_count += 1
		dist = us_dist(15)
		print('Pulses: ' + str(pulse_count * 1)) 
		print(dist)
		# once object is no longer in view of sonic sensor, we turn back
		if (dist > 140):
			break
		
	print('Turning back...')
	sleep(1)
	# will rotate using specific number of pulses based on how wide the object is
	enc_tgt(1, 0, int(math.ceil(float(pulse_count)/2)))
	right()

	sleep(1)

	# move forward in 1 pulse rotations until sensor confirms we are 55 cm away
	while True:
		dist = us_dist(15)
		enc_tgt(1, 0, 1)
		forward()
		print(dist)
		# after many runs, we see that the robot is guaranteed to veer away
		# from the object, therefore we reset the robot's local frame
		if (dist < to_distance):
			print(dist)
			stop()
			break
		sleep(1)

	sleep(1)
		
	if not final:
		# reconfigure encoder target so that robot's sensor is reset once we rotate
		# in order to locate the object again
		enc_tgt(1, 0, 5)
		right_rot()
		sleep(1)

search_and_dest(80, False)
search_and_dest(50, False)
search_and_dest(23, True) # Note that the distance sensor reads 20cm as 23
    
