This is a Lab 1 submission for group 13
Team members: Ben Barton (bdb2130), Connor Hargus (cjh2209), Jason Perez (jp3476)

Question 1: Done.

Question 2: Code implementation is found in dancing.py. We use a for loop to generate random integers that dictate whether it moves fwd, bwd, left or right.

Question 3: Code implementation is found in sensor_accuracy.py. The following were our sensor's detected distances for the following actual distances:

5cm -> 6
30cm -> 38
60cm -> 78

Question 4: Code implementation is found in beam_width.py. Beam width is approximately 31 cm +- 3cm. Code works primarily with a thin, cylinder object that takes about ~3 degrees of the sensor's conical beam. Our algorithm starts with the sensor's servo angle at ~80 degrees. We then continuously increment the angle until the thin, cylinder object is in view. The program will record this distance and continue to increment the servo angle. Once object is no longer within the sensor's beam, we compute the total beam width using arithmetic. 

Question 5: Code implmentation is found in locate_object.py. Out of 10 tests using different objects, the gopigo robot will accurately stop at around 20cm in front of the object about 9/10 times. Failures occur usually due to sensor misreads (ie. reading 60cm in the sensor when there are no objects nearby within 3+ meters) or when robot wheels lack enough traction on the ground causing a shift in linear direction.

Our function search_and_dest will take in a distance parameter and a boolean marker. We run this function 3 times in order to detect the object by first rotating the robot to the left until the sensors pick it up. It will then stop then continue to track the object for a certain number of pulses. Once the object is no longer in range, the robot will once again stop and rotate to the right about half the number of pulses it took for the sensor to pass the object. It will then continue on straight to the object - seeing as our robot does not move in a perfectly straight line, we reset the robot's local frame at sensor distances 50cm and 23cm. At each distance, our algorithm repeats until the robot is finally within the 20cm distance mark.  