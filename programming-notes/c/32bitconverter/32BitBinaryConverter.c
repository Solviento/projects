/*
testing.c
LAB 1 - DECIMAL TO 32 BIT TWO'S COMPLEMENT BINARY CONVERTER
Sep 19, 2016
Jason
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void decimalBinaryConverter(int x);
void charArrayReverser(char *bits, int x);
void fullBitFormatter(char *bits, int x);
void inverterWithAdder(int *bits);
void charToIntArray(char *bits);

void decimalBinaryConverter(int x){

	//Smart Things to do (in hindsight)
	//create a padded list of 32 0's
	//Do the decimal to binary converter
	//Replace individual elements in padded list
	//as needed
	//Would most likely have to iterate in
	//reverse of padded list
	//Bam, 32 bit conversion complete

	char unformattedBits[32] = "";

	//unformattedBits is backwards, need to flip
	char zero = '0';
	char one = '1';

	int y = x;

	if (x < 0){
		y = (x * -1);
	}

	int division = (y / 2);

	while(division > 0){

		division = (y / 2);

		int bit = (y % 2);

		if (bit == 0){
			strncat(unformattedBits, &zero, 1);
		}
		if (bit == 1){
			strncat(unformattedBits, &one, 1);
		}

		y = division;

	}

	//Returns a binary representation of x (backwards)
	// 2 = 01 (supposed to be 10)
	//Needs to be fed into charArrayReverser

	charArrayReverser(unformattedBits, x);

}

void charArrayReverser(char *bits, int x){

	char semiformattedBits[32] = "";
	char zero = '0';
	char one = '1';

	size_t length = strlen(bits); //Can be used as int

	for (int i = length; i > -1; i--){

		if (bits[i] == '0'){
			//append to front char array with '0'
			strncat(semiformattedBits, &zero, 1);
		}
		if (bits[i] == '1'){
			//append to front char array with '1'
			strncat(semiformattedBits, &one, 1);
		}
	}

	//Reverses bits
	// 01 -> 10

	fullBitFormatter(semiformattedBits, x);
	//To be fed into fullBitFormatter

}


void fullBitFormatter(char *bits, int x){

	char formattedBits[32] = "";

	size_t move = strlen(bits);
	int length = move;
	//len can be 1-31 (max in is 2147483647), Special case for neg. max int!!
	int difference = (32 - length);

	// Say len = 2 (bits = 10)
	// 32 - 2 = 30
	for(int i = 0; i < difference; i++){

		strncat(formattedBits, "0", 1);

	}
	//All zeros in place

	for(int j = 0; j < length; j++){

		if (bits[j] == '0'){
		//append to front char array with '0'
			strncat(formattedBits, "0", 1);
		}
		if (bits[j] == '1'){
		//append to front char array with '1'
			strncat(formattedBits, "1", 1);
		}
	}

	if (x >0){
		printf("%s \n\n", formattedBits);
	}
	if (x < 0){
		charToIntArray(formattedBits);
	}

	//Formats 10 -> 0000 0000 ... 0010
}

void charToIntArray(char *bits){

	//Receives char[32] = 0000 ... 0010

	int convertedBits[32] = {};

	for(int i = 0; i < 32; i++){

		if(bits[i] == '0'){
			convertedBits[i] = 0;
		}
		if(bits[i] == '1'){
			convertedBits[i] = 1;
		}

	}

	inverterWithAdder(convertedBits);

}

void inverterWithAdder(int *bits){

	// To be used only for neg. ints

	int newBits[32] = {};

	for (int i = 0; i < 32; i++){
		if (bits[i] == 1){
			newBits[i] = 0;
		}
		else{
		    newBits[i] = 1;
	    }
	}

	for (int i = 31; i > -1; i--){
	    if (newBits[i] == 1){
	        newBits[i] = 0;
	    }
	    else{
	        newBits[i] = 1;
	        break;
	    }
	}

	for (int i = 0; i < 32; i++){

		printf("%d", newBits[i]);

	}
}

int main()
{
	int x = 2147483647;
	int y = -2147483647;
	//int z = 100023112;
	//int m = -1000;

	//int arr[32] = {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0};

	//inverterWithAdder(arr);
	//char bits[32] = "10101010101010101010101010101010";

	//charToIntArray(bits);

	//bitAdder(bits);

	decimalBinaryConverter(x);
	decimalBinaryConverter(y);

	//printf("%d\n\n", ~x);
	//printf("%d", ~-z);
}
