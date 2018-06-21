Does the following program crash? What's the output?

MyString var = "hello";
MyString &refVar = var;			// Stores var's data into the reference of refVar (any changes made to var
									// will also make changes to refVar
var = "hi";						// Changes contents of cvar

MyString *pointer1 = &refVar	// Store's refVar's memory address reference into pointer
MyString *pointer2 = &var;		// Stores var's reference (memory address) into pointer

assert(pointer1 == pointer2);	// Equality test
cout << refVar << endl;			// Will output "hi"

---

$ ls
Makefile mystring.cpp mystring.h main.cpp

$ git status
# Working directory clean
$ make
$ git add mystring.ccpp
$ git add x

Git status of each file?

---

Does this program print 10?

int get_num_elements(int a[]){
	return sizeof(a) / sizeof(int);
}
int main(){
	int a[10];
	cout << get_num_elements(a) << endl;	// When a[10] gets passed as an arg, it is casted to a pointer
											// meaning its size will take 8 bytes
	return 0;
}

If the first line were changed to
int get_num_elements(int *a){

Then the result would still be the same and the output would be (8 / 4 = 2)

Questions related to lab 7:

Entering the web root into the browser client will request for THREE different things:
index.html
ships.jpg (The browser requests this since the machine does not have this stored locally)
crew.jpg (Same as above)

Therfore, there are three HTTP requests when accessing columbia.edu:8888/cd3157/tng/

For lab 7, we never make ANY connections to mdb-lookup-server ONLY http-server. 

http-server calls connect to mdb-lookup-server when a search query is made

mdb-lookup-server never calls connect since it only receives and send search query data

Remember to look at the Sockets API summary pdf

This shows that http-server and mdb-lookup-server calls listen() only once in the overall process

---

What happens when?

MyString * f(){
	MyString s("123");
	return &s;
}
int main(){
	cout << *(f()) << endl
	return 0;
}

Will return 123, the memory is preserved since it is returned as a pointer

What happens when?

MyString f(){
	MyString s("123");
	return s;
}
int main(){
	cout << *(f()) << endl
	return 0;
}

Bad! You can't dereference the return type of MyString f(). 

Why does this print 1?

const char *f(){
	return "123";
}
int main(){
	cout << *(f()) << endl;
	return 0;
}

It prints '1' since the dereference (*) will point to a single char as prescribed by its
original return data type. "123" is a char array pointed to by a pointer. If we did not have
the * before f() in the cout call, then it would print "123" since the pointer is not 
dereferenced during the call.

What happens when?

MyString *f(){
	MyString *s = new MyString("123");
	return s;
}
int main(){
	cout << *(f()) << endl;
	return 0;
}

Memory leak! It will "123" since the object type is MyString. However, since the *s pointer
was never deleted, this will cause a memory leak during runtime. For cout, MyString's internals
include char *data and int len. 
How many bytes do you lose?
We lose in total:
MyString {
	int len;
	char *data = "123\0"
}

4 bytes (from int len)
8 bytes (from char *)
4 bytes (from "123")
16 bytes

What happens when?

SmartPtr<MyString> f(){
	SmartPtr<MyString> s(new MyString("123"));
	return s;
}
int main(){
	cout << *(f()) << endl;
	return 0;
}

No memory leaks. Will print "123"

What happens when:

vector<MyString> vtr;
vector<MyString>::iterator f(){
	vtr.push_back("123");
	return vtr.begin();
}
int main(){
	cout << *(f()) << endl;
	return 0;
}

*(f()) will dereference the iterator pointer and give you the contents of MyString which is
"123". No memory leaks since vector's destructor will clear all resources used.

What happens when:

SmartPtr<MyString> f(){
	MyString t = MyString("1") + "2" + MyString('3'); // Error
	// "1" gets promoted to char *, which is handled by MyString's constructor
	// "2" gets promoted to MyString
	// '3' is a char, which is not handled by MyString so it will return an error
	MyString *s = new MyString();

	*s += t;
	return SmartPtr<MyString>(s);
}


