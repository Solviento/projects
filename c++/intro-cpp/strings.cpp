#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

int main(){

	string birthday = "Birthday";

	cout << birthday << endl;

	string yourName;

	cout << "What is your name ";

	getline(cin, yourName);

	cout << "hello " << yourName << endl;

	double eulersConstant = .577721;

	string eulerGuess;

	double eulerGuessDouble;

	cout << "What is Euler's Constant? ";
	getline(cin, eulerGuess);

	eulerGuessDouble = stod(eulerGuess); // Converts string to double

	if (eulerGuessDouble == eulerConstant){

		cout << "You are right" << endl;
	}
	else{
		cout<< "you are wrong" << endl;
	}

	// strings
	// size()
	// empty()
	// append(" .. ")
	// compare(" .. ")
	// find(" .. ", #)

	return 0;

}
