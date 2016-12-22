General tips and extra info learned
from doing past finals

Arrays vs Pointers

- Arrays can be used interchangeably with pointers
HOWEVER, do not confuse this with pointers being used
interchangeably with arrays. i.e:

	char array[5] = "Bell";

	char *p = array;	// Okay 
	
	array = p; 			// Bad!

	-- in a main() function far far away --

	main(int argc, char **argv)

	char **ptr = &argv[0];	// &argv[0] is EQUIVALENT to char **argv

	// Likewise

	char *p = "Bell";

	[valid variable] = &p[0]; // Also EQUIVALENT
