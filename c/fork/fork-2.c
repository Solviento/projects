#include <stdio.h>


int main()
{
	if ( fork() == fork() ){
		fprintf(stderr, "Z");
	} else {
		if (waitpid( (pid_t) -1, NULL, 0) != -1)
		{
			fprintf(stderr, "Y");
		} else {
			fprintf(stderr, "X");
		}
	}
	return 0;
}

