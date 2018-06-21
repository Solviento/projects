Smart Pointers

Why use smart pointers?
- They make pointers more manageable + better code readability and clean up

Using Smart Pointers

#include <string>
#include <memory>

using namespace std;

class Dog
{
	string name_;

	public:
		Dog(string name)
		{
			cout << "The dog: " << name << " was created." << endl;
			name_ = name;
		}
		Dog()
		{
			cout << "Nameless dog created." << end;
			name_ = "nameless";
		}
		void bark()
		{
			cout << name_ << " rules!" << endl
		}
		// Destructor ~() not needed!
};

void foo()
{
	shared_ptr<Dog> doggy(new Dog("Gunner")); // Count = 1
	// Two steps: 1. "Gunner" is created. 2. doggy is created

	// Smart pointer ('shared_ptr') can be declared and initialized in
	// the parenthesis field using 'new' + Object-Name + any-fields

	{
		shared_ptr<Dog> p2 = p; // Count = 2
		p2 -> bark();
	}
	// Count = 1

	p->bark(); 
	// No cleanup!
	// Count = 0 - The Dog 'Gunner' is deconstructed
}

int main()
{
	foo();

	// Pitfalls:

	Dog *d = new Dog("Tank");
	shared_ptr<Dog> p(d);	// p count = 1
	shared_ptr<Dog> p2(d);	// p2 count = 1

	// This is a bad use of the smart pointer, an object should be assigned
	// to a smart pointer as soon as it is created. 
	// Instead, below is exception safe:

	shared_ptr<Dog> p = make_shared<Dog>("Tank"); // Faster + safer
	
	(*p).bark(); // Can be dereferenced 
}
