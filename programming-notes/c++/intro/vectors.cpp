#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

int main(){
	
	/* Vectors are like arrays, but their size can change */

	// vector <data type> variableName Size

	vector <int> lotteryNumVect(10);

	int lotteryNumArray[5] = {4, 13, 14, 24, 34};

	lotteryNumVect.insert( lotteryNumVect.begin(), 
		lotteryNumArray, lotterNumArray+3); // Takes and copies first 3 elements in int array to vectory array

	cout << lotteryNumVect.at(2) << endl; // 14 should pop up

	lotteryNumVect.push_back(64); // Pushes '64' to the back of the vector

	cout << "last value " << lotteryNumVect.back() << endl;

	lotteryNumVect.pop_back();

	return 0;

}
