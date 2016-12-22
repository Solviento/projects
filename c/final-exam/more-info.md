General tips and extra info learned
from doing past finals

Comprehensive Guide of Pointers

- Envisage a pointer as containing a numeric memory address

- Full visual of a pointers and pointees (initialized data in either stack/heap)

	const char *p = "abc";

	Boils down to:

	p = 'a', 'b', 'c', '\0'

	In the actual memory:

	Memory Address (hex)	Variable name	Contents

	1000									'a' == 97 (ASCII)
	1001									'b' == 98
	1002									'c' == 99
	1003									'0' == Null
	...
	2000-20003				p				1000 (hex)

- What it means to 'dereference'

	To refer to the character p points to, we dereference p using any of the below:

	*p		// *p == 'a'	The first character that p points to is 'a'

	p[1]	// p[1] == 'b'	p[1] dereferences a pointer and then moves past one
							whole data type
	
	*(p+1)	// *(p+1) == 'b' Another notation for p[1]

	- We can move pointers through the pointee data

		++p;	// Will now point to address 1001 which holds 'b'

- Pointers in functions

	When a function is written as:

	void reverseList(struct List *list){}

	The following are acceptable:

	struct List *ltr;

	reverseList(ltr);		// No dereference needed, ltr is a pointer

	struct List rank;

	reverseList(&rank);		// Reference needed, 'rank' is located on the stack so
							// it requires a & for it to work
	
	You may also need to convert struct variables like so:

	struct sockaddr_in serverAddr;	// Non-pointer variable stored on stack

	connect(sock, (struct sockaddr *)&serverAddr,..);

	Since connect requires a sockaddr * type in its second parameter, we first
	reference 'serverAddr' (this essentially allows us to use it as a pointer arg)
	and then cast convert it to a sockaddr * type for us to use in connect()

- Pointers in Conditional Statements

	Example:

	struct Node *cur = list->head;

	while(cur){ .. }		// Taken from a linked list program. Will keep the while
							// loop going until 'cur' node reaches a NULL value
	
- Converting void * in C

	When you have a function as:

	static void printDouble(void *p) { ..}

	And you would like to perform some operation on it which requires a double
	or float, you would need to convert using the following:

	*(double *) digit = *(double *)p;	// Cast as double *, then dereference to
										// access the data held pointed to by p

- Arrays vs Pointers

	Arrays can be used interchangeably with pointers
	HOWEVER, do not confuse this with pointers being used
	interchangeably with arrays. i.e:

	char array[] = "Bell";

	char *p = array;	// Okay 

	char *p = "Shots";	// Okay

	char *p = array[2];	// Also okay. Why? array[2] is basically &array[2]
	
	array = p; 			// Bad! Arrays are CONST like pointers

	In general, arrays are like pointer constants in that they CANNOT be used
	as lvalues (i.e. lefthand values, constants also CANNOT be modified)

	-- in a main() function far far away --

	main(int argc, char **argv)

	char **ptr = &argv[0];	// &argv[0] is EQUIVALENT to char **argv

	// Likewise

	char *p = "Bell";

	char *copy = &p[0]; // &p[0] is EQUIVALENT to char *p

	char *dup  = p;		// p by itself is the pointer, no need for * or &

- char ** and char * and char

	char c				// Basically a single literal

	char *ptr			// Basically a string (an array of string literals)

	char **list			// Basically a a list of strings (like a sentence!)
						// Also interpreted as a pointer to an array of pointers

	It gets trickier though, say we have:

	void duplicateArgs(char **copy){    // Command line args are usually in the form
										// of char **. Ex: ./fun abc 123
	char **p = copy;	// Makes another copy of the double pointer

	while(*p){	
	
	// Why *p? 

	// p points to the overall array of pointers

	// *p points to the individual pointer in the overall array
	
	By REFERENCING we go down deeper one level to access the real data that is
	pointed to by the pointer

	// **p points to the individual data member hidden underneath
	// In this case it points to the char

	By referencing again we access the actual data pointed to by the double pointer

		free(*p++);
	}
	free(copy);
	}

	Visual:

	**copy (what we start with)					Handled as: copy

	[simple] [message] [stored]

	*copy (can also be iterated as seen above) 	Handled as: *copy

	[simple]
	
	copy (also iterable)						Handled as: **copy

	[s]

	Confusing right? I know. 

- Pointers get tricky in the way they're implemented such as:

	float a = 5.2; 		// Recall that float ia FOUR byte data type

	char *ptr;

	ptr = (char *) &a;	// Reference then Dereference with char *
						// This is okay, since we go down one level (called
						// the memory address) and then back up (where pointer a is)
	
	printf("%d ", *ptr++);	// Why *ptr? Since we are doing pointer arithmetic
							// we must dereference (REMEMBER: the act of
							// dereferencing a pointer means to refer to data
							// that ptr points to, in this case, the float data
	printf("%d ", *ptr++);

	Pointer arithmetic and cast conversion is confusing, but it may be understood as:
	float a (four bytes - 8 bits per byte)

	0000 0000 0000 .... .... 1010 (32 bit binary)

	When (char *)& is cast to a, it boils down to the following:
	(Remember: char is 1 byte)

	(0000 0000) (0000 0000) ..... (0000 1010) (Four groups of 8 bits)

	So when *ptr is iterated by (++), it will point to the values of the
	individual byte groups as shown above. So the first printf will be the
	value of the first 1 byte binary representation and second will the second
	1 byte binary group, etc.

- Smart pointers

	In general, use smart pointers like shared_ptr or unique_ptr

	However, weak_ptr is recommended for doubly linked lists since you will
	run into memory leaks if using shared_ptr.
	
Valgrind

- Valgrind is initated as:

valgrind ./program file.txt . .

- Leaks and Errors

	Leaks occur when you ALLOCATE memory that you DID NOT free. In general, leaks
	will cause a program to stack overflow

	Errors occur when your attempt to read or write INVALID memory blocks, i.e. 
	memory that you DO NOT have access to

- Valgrind Results

	Conditional jump OR move depends on unitialized value(s)

		- This means that your program has a value that is not initialized in all
		cases before it used. For ex:
			
			char *array;	// Not initialized, bad :(

		- All variables must be initialized in every case

	Invalid free()
		
		- This means that you are freeing a memory TWICE or freeing a pointer that
		points to the stack

	Invalid read of size X

		- This means that you are trying to read memory that you do not have
		access to such as:

			Reading after the end of an array

			Reading memory already freed

			Reading a string that does not end with a null '\0'

- Resolving Leaks

	Common causes:
		
			failing to free() memory

			failing to fclose() a file pointer


