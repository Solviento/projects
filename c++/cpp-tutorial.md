Intro to C++

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

	Pt(double t = 0){
		x = y = t;
		cout << "hi" << endl;
	}
};

int main(){

	Pt p1;

	//cout << "hello " << 3157 << "!" << endl;

	p1.print(); // Calling inner method print() on object "Pt" p1

	return 0;

}
