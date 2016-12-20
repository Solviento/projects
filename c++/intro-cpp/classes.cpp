#include <string>
#include <fstream>

using namespace std;


class Animal{

	// Private variables are protected as part of "encapsulation"
	// Makes it useful for interfacing with a user
	private:
		int height;
		int weight;
		string name;
	
		static int numOfAnimals;	// "static": This variable's value is going to be shared by every object that is every created
	
	public:
		int getHeight(){
			return height;
		}
		int getWeight(){
			return weight;
		}
		string getName(){
			return name;
		}
		void setHeight(int cm){
			height = cm;
		}
		void setName(string s){
			name = s;
		}
		void setWeight(int kg){
			weight = kg;
		}

		// Constructor
		Animal(int, int, string);

		// Destructor

		~Animal();

		// Default constructor

		Animal();
	
		void setAll(int, int, string);

		// Static method - These are attached to the class, NOT the object itself
		static int getNumberofAnimals() { return numOfAnimals; }
};

int Animal::numOfAnimals = 0;

void Animal::setAll(int height, int weight, string name){

	this -> height = height;
	this -> weight = weight;
	
	Animal::numOfAnimals++;
}

Animal::Animal(int height, int weight, string name){

	this -> height = height;
	this -> weight = weight;
	Animal::numOfAnimals++;
}

Animal::~Animal(){
	// do Something
}

Animal::Animal(){
	Animal::numOfAnimals++;
}

void Animal::toString(){

	cout << this->name << " is " << this->height << " cms tall and "
		<< this->weight << " kgs in weight" << endl;
}

/* Inhertance */

class Dog : public Animal{

	private:
		string sound = "Woof";
	public:
		void getSound() { cout << sound << endl;}
	
		Dog(int, int, string, string);

		Dog() : Animal(){};

		void toString();
};

Dog::Dog(int height, int weight, string name, string bark) :
Animal(height, weight, name){
	this-> sound = bark;
}

void Dog::toString(){
	
	cout << this->getName() << "is " << this->getHeight() << endl;

int main(){

	Animal fred;

	fred.setHeight(33);


}
