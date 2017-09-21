#include <stdio.h>



int main(int argc, char* argv[]){

	/*pseudocode for pipeline rendering */

	for i = 1 to num_objects{

		split object(i) into fragments
		calculate the shading on each fragment 
		project fragments to pixels
		pixel keeps color of closest fragment
	
	}
	return 0;
}
