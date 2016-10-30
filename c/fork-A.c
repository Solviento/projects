#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/* Small test program for learning fork, parent-child processes */
/* First file committed using Git (non-coursework) */

int main(){


	//pid_t
	/*pid is similar to an int, except that it used mainly
	for capturing and returning values */

	pid_t childPID = fork();

	if (childPID < 0){
	//If fork() returns negative int, child process failed to initialize
		perror("fork() error");
		//perror is our go to function for error handling
		exit(-1);
		//exit(-1) tells user that something catastrophic has happened
		//exit(0) tells user that everything ran normally
	}

	if (childPID != 0){
		/* If child's PID is not 0, then that we are actually inside
		the parent process */
		printf("We are in the parent process: %d, this is the child process: %d", getpid(), childPID);
		wait(NULL);
		/* In order to save resources, we tell the parent process to wait for the child process to catch up and join */
	}
	else{
		printf("We are in the child process: %d, this is the parent process: %d \n", getpid(), getppid());
		//getpid()
		/* returns pid number of whatever process is currently in use */
		//getppid()
		/* Really lazy syntax, same as above but returns process id number of whatever process is one level above */
		execl("/bin/echo", "echo", "Hello", "World", NULL);
		//execl
		/* executes a built in bash program, echo-Hello-World-Null will echo "Hello World" as expected. Null is used a terminator arg */
	}

	return 0;

}
