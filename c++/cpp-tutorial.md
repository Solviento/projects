Intro to C++

(From AP)

#include <iostream>

using namespace std;

/* Similar to structs in C */
class Pt{

public:
	double x;
	double y;

	/* Inner methods now available! (like java) */
	
	void print() {
		cout << "(" << x << "," << y << ")" << endl;
	}

	/* This should be placed before print() for better clarity */
	/* Will set the instance variables of Pt to zero AND print out Hi */

	/* A constructor */
	/* A constructor sets up values of the class */

	Pt(double t = 0){
		x = y = t;
		cout << "hi" << endl;
	}

	/* Secondary constructor */
	/* This is useful for when you are copying the same strcture and need
	to the same constructor functionality */

	Pt(Pt& another){
		x = another.x;
		y = another.y;
		cout << "copy" << endl;
	}


	/* A deconstructor */
	/* A deconstructor will be called once the main program ends */
	
	/* Important! If you do not declare a constructor/deconstructor explicitly
	the compiler will do it for you. */

	~Pt(){
		cout << "bye" << endl; // As program ends, main will spit out "bye"
	}

	/* Overriding = */

	Pt& operator=(const Pt& rh){
		x = rhs.x;
		y = rhs.y;
		cout << "op=" << endl;
		return *this;
	
	void print2();
}; // Classes end in ;

/* Proper way of declaring a function for Pt */

void Pt::print2(){

	// Pt *this;
	cout << "(" << this->x << "," << y << ")" << endl;
}

void transpose(Pt& p){
	
	double t = p.x;
	p.x = p.y;
	p.y = t;
}

int main(){

	Pt p1;

	//cout << "hello " << 3157 << "!" << endl;

	p1.print(); // Calling inner method print() on object "Pt" p1
	p1.print2(); // Calling outer Pt method print2()

	transpose(p1); // Will change p1's x and y instance values
		       // This is possible through the use of &
	p1.print(); // If no secondary constructor exists, C++ will make its own 

	return 0;

}

Differences between C and C++

- C++ uses new and delete operators for memory managements, C uses library functions
- C++ extends structs and unions and includes classes
- C++ has templates, C does not
- C++ has operator and function overloading
- C++ requires type casts conversion while C may let you get away with it
- typedef in C++ creates unique types, in C it creates a type alias

C++ Mentality

- You should use less pointers in favor of references and derived classes
- You should group similar functions working with different types in a template
- You should place identifiers in a namespace
- You should think of everything as objects. If writing a control program for a place, you should create a class called Plane and create functions inside it


