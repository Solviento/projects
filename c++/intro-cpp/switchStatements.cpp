#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

int main(){

	/* Switch statements are generally used when there are a limited
	   number of possible options */

	int greetingOption = 2;

	switch(greetingOption){
	
		case 1: // If greetingOption is 1, execute
			cout << "bonjour" << endl;
			break;

		case 2:
			cout << "Hola" << endl;

		case 3:
			cout << "Hallo" << endl;

		default: // If greetingOption not matched, execute default
			cout << "Hello" << endl;

	}

}
