from gopigo import *
from time import sleep

'''Calculates the beam width.

Set up the GoPiGo so that its sensor is less than 60 centimeters away from a single object
at a direct 90 degree angle left of the sensor.'''

# WILL WORK ONLY FOR VERY THIN OBJECTS IE. A BROOM OR LONG THIN CYLINDER

servo_pos=180

servo(servo_pos)
sleep(1)

while True:
    servo(servo_pos)
    # continuously increments servo angle
	servo_pos += 1
    sleep(.5)
    dist = us_dist(15)

	# search, detect object, once detected - record the servo angle
	# keep sensor servo moving until object is no longer in view
	# compute then store measured beam width

	objdetect = 0
	objnoshow = 0
    
	print("distance: " + str(dist))
    
	if(dist < 60):
        #print('Beam width: ' + str(2 * (180 - servo_pos)))
        #break
		objdetect = servo_pos
	
	if(dist > 60):
		objnoshow = servo_pos
		beamwidth = objdetect - objnoshow
		print(str(beamwidth));
		break;
