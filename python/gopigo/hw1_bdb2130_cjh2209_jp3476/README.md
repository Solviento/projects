This is a Lab 1 submission for group 13
Team members: Ben Barton (bdb2130), Connor Hargus (cjh2209), Jason Perez (jp3476)

Question 1: Done.

Question 2: Code implementation is found in dancing.py.

Question 3: Code implementation is found in sensor_accuracy.py. The following were our sensor's detected distances for the following actual distances:

5cm -> 6
30cm -> 38
60cm -> 78

Question 4: Code implementation is found in beam_width.py. Beam width is approximately 122 cm +- 5cm.

Question 5: Code implmentation is found in locate_object.py. Out of 10 tests using different objects, the gopigo robot will accurately stop 20cm in front of the object about 9/10 times. Failures occur usually due to sensor misreads (ie. reading 60cm in the sensor when there are no objects nearby within 3+ meters) or when robot wheels lack enough traction on the ground causing a shift in linear direction.