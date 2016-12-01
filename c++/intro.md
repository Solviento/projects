Recommended Reading:
A Tour of C++ (Ch.1, ch.2.1-2.3, ch.3.1-3.3, ch.4.1-4.2, ch.4.6, ch.4.6.2)

C++ Overview

- C++ features object oriented programming
	- User defined types (classes)
	- Polymorphism (inheritance) [Very, very similar to Java]
- Generic programming (templates) [Used to deal with 'AnyType' objects]
- Exceptions (fileIO, overflow, etc)
- Full blown std. library 
- Uses STRING and not CHAR* for char arrays

AP will concentrate on
- Fundamentals
	- Writing safe and correct C++ code
	- RAII: Resource Acquisitioin is Initialization
		- Binds life cycle of a resource to the lifetime of an object
	- Standard library basics
	- Practical approaches

AP will skip
- Polymorphism (inheritance: Parent/Child)
- Exceptions
- Everything else

Strings in C

Stack allocation:
- char bug[100];

Heap allocation:
- char *buf = (char*) malloc(100);

Struct:
typedef struct{
	char *s;
	int len;
} String;
String *allocString(const char *s);
void deallocString(String *str);
int appendString(String *str, const char *s);

Declaration
- Declaration tells the compiler the name and type of an object, which is
defined somewhere else.
	- int f(int x);
	- struct MyList;
	- class Mystring;
	- template<class T>
- Definition tells the compiler an assigned value for a variable or struct
with members listed in its structure
	- int x;

