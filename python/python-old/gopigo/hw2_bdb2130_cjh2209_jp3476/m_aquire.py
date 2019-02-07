import math
import numpy as np
from gopigo import *
from time import sleep

# set servo angle to 78 deg (our equivalent to ~90 degrees)
servo(78)

degrees_per_pulse = 5.625
thresDist = 25
global_trans_mat = np.identity(3)
set_speed(70)
servoAngle = 0

def main():
	
	follow_m_line()

def follow_m_line():
	
	# gbl_trans_mat returns current location of robot
	global global_trans_mat

	while True:
	
		# dist_dest returns the distance left to traverse on the x-axis
		dist_dest = 300 - global_trans_mat[0][2]
		
		enc_tgt(1,1,10)
		forward()
		sleep(1)
		trans_matrix = np.array([[1, 0, 10],[0, 1, 0], [0, 0, 1]])
		global_trans_mat = np.dot(trans_matrix, global_trans_mat)
		print('loc x: ' + str(global_trans_mat[0, 2]) + ' y: ' + str(global_trans_mat[1,2])) 
		
		if(dist_dest <= 0 or us_dist(15) < thresDist):
			if(dist_dest <= 0):
				stop()
				return
			else:
				enc_tgt(1,0,15)
				left_rot()
				
				rot_mat = np.array([[math.cos(math.radians(90)), -math.sin(math.radians(90)), 0],
							[math.sin(math.radians(90)), math.cos(math.radians(90)), 0],
							[0, 0, 1]])
		
				global_trans_mat = np.dot(rot_mat, global_trans_mat)
				
				sleep(1)
				stop()
				rot_matrix = np.array([[0, -1, 0],[1, 0, 0], [0, 0, 1]])
				loc_trans_mat = np.dot(trans_matrix, global_trans_mat)
				print('loc x: ' + str(global_trans_mat[0, 2]) + ' y: ' + str(global_trans_mat[1,2])) 
				follow_perim()

		
def follow_perim():
	
	global loc_trans_mat
	
	servo(0)
	sleep(1)
	servoAngle = 0
	print('about to hit thresh while!')
	'''
	while(us_dist(15) < (thresDist)+40):
		
		servoAngle += 5
		print('moving servo!')
		print("sonar distance: " + str(us_dist(15)))
		print('servo angle ' + str(servoAngle))
		servo(servoAngle)
		sleep(0.5)
	
	turn_angle = 90 - servoAngle
	turn_angle *= 0.3
	print("turn angle: " + str(turn_angle))


	if (turn_angle > 0):
		print("turn angle > 0")
		enc_tgt(1,0, int((turn_angle / degrees_per_pulse)))
		right()
		sleep(1)
		
	if (turn_angle < 0):
		print("turn angle < 0")
		enc_tgt(0,1, int(turn_angle / degrees_per_pulse))
		left()
		sleep(1)
'''
	
	if (us_dist(15) < thresDist):
		enc_tgt(0,1, 2)
		left_rot()
		trans_mat = np.array([[1, 0, 10],[0, 1, 0], [0, 0, 1]])
		rot_mat = np.array([[math.cos(math.radians(-10)), -math.sin(math.radians(-10)), 0],
							[math.sin(math.radians(-10)), math.cos(math.radians(-10)), 0],
							[0, 0, 1]])
		
		global_trans_mat = np.dot(rot_mat, global_trans_mat)
		global_trans_mat = np.dot(trans_mat, global_trans_mat)
		
		sleep(1)
	elif (us_dist(15) > thresDist):
		enc_tgt(1,0, 2)
		right_rot()
		sleep(1)
	
	enc_tgt(1,1,10)
	forward()
	sleep(1)
	
	follow_perim()

if __name__=='__main__':
	main()
