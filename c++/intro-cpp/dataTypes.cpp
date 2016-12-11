#include <iostream>		// Allows use of cout
#include <vector>		// Vectors
#include <string>		// Strings
#include <fstream>		// input output

using namespace std; 

int main(){

	cout << "Hello world" << endl; 	 

	const double PI = 3.1415926535;	// 4 bytes

	char myGrade = 'A'; 			// 1 byte

	bool isHappy = true;			// ?

	int myAge = 39;					// 4 bytes

	float favNum = 3.14159;			// ?

	double othefavNum = 1.1618;		// 6 or 8 bytes

	cout << "My age " << myAge << endl;

	cout << "Size of int " << sizeof(myAge) << endl;

	/* long int, long long etc, all have similar traits from C */

	/* +,-,/,*, etc are also similar from C */

	/* Differences in ++ */

	int five = 5;

	cout << "5++ " << five++ << endl; // Will increment five AFTER it has been passed to cout, will output a value of 5

	cout << "++5 " << ++five << endl; // Will increment five BEFORE it has been passed to cout, will output a value of 7

	// -- works the same above

	five += 6; // Adds 6 onto value in variable 'five'

	// Casting
	
	cout << "4 / 5 = " << (float) 4 / 5 << endl;	// Will output 0.8 since type is casted to float

	return 0;		// 0 stands for an execution that went perfectly fine

}
