Data Types and their Sizes

	char	1 byte
  un. char	1 byte
 sig. char	1 byte
	int		4 bytes
  un. int	4 bytes
   short	2 bytes
  un. short 2 bytes
   long		4/8 bytes
   float	4 bytes
   double	8 bytes

Binary (Bit-wise) Operators

	&		AND (copies a bit to the result if it exists in both operands)
	|		OR	(copies a bit if it exists in either operand)
	^		XOR (copies the bit if it is set in one operand but not both)
	~		NOT	(flips all the bits)
   << 		Left shift (The left operands value is moved left by the # of bits specified by the right operand)
   >>		Right shift (Same as above but with operands switched)

Hexadecimal Conversions

- Normally you would multiply 16^0, 16^1, 16^2... for each bit (from LSB to MSB)

Popular Hexadecimals (AP)

0xFF	-	255

Storage Classes

static - Retained when out of scope, static global variables are confined to the
		 scope of the compiled object file they were declared in

extern - Used when the variable is declared by another file

Recursion

In AP, we use structs with a recursive structure pointer inside. This is most 
useful when we implement them in linked lists

Accessing Structs

strName.x	- Accesses member 'x' of a struct declared in the stack

ptrName->x	- Accesses member 'x' of a struct declared in the heap

Pointers (major topic in AP)

int/char/struct *x	- All pointers have a data type like normal variables

void *v		- Pointers can also have an incomplete type

int x[*] 	- Arrays can also be used as pointers to the first array element (always used in trick questions for AP)

  x			- By itself, a pointer variable name will contain a memory address that points to another memory address that stores a value (the 'pointed' to memory address and its stored value will be used, not the pointer itself)

 *x			- Dereference. When you want to access the data/value in the memory that the pointer points to, then you DEREFERENCE the pointer

 &x			- Reference. Will return and give you access to the memory address of the variable x. REFERENCE can be imagined as an actual memory address reference in an address book

Return Values

return &x	- Returning a variable by pointer

Looping

while		- Loop skipped if test condition initially false

do while	- Always runs through loop at least once

File IO

"r"/"rb"	- Read text/binary file

"w"/"wb"	- Write new or over existing text/binary file

"a"/"ab"	- Write new or append to existing text/binary file

"r+"		- Read and write existing file

"w+"		- Read and write new/existing



