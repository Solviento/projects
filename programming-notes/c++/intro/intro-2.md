Stack and Heap allocations

For C & C++:

struct Pt{
	int x;
	int yl
}

C:
	struct Pt p1; // stack alloc.

	struct Pt *p2 = malloc(sizeof(struct Pt); // heap alloc.
	... free(p2);

C++:
	struct Pt p3(0, 0); // stack alloc.
	... // p3 will get deconstructed at end of its scope

	struct Pt *p4 = new Pt(0, 0); // heap alloc.
	... delete p4 // dealloc. p4


Constructs in C++: 'new' and 'delete' operators + references '&'

// stack-allocated objects String s1; String s2 {};
String s3("hello");
// heap-allocated objects String *p1 = new String();
// heap-allocated array of objects String *a1 = new String[10]; // pointer
String *p2 = p1; String *p3 = &s3;
// reference String& r3 = s3; String& r1 = *p1;
// more stack-allocated objects,
// which are duplicates of the existing objects String s4(r3); String s5 = s3;
// heap-allocated object must be deleted delete p1;
// heap-allocated array of objects must be deleted differently delete [] a1;
