/* StrList.cpp */
#include "mystring.h"
#include "strlist.h"
#include <cstring>
#include <cstdio>
#include <cstdlib>

extern "C" {
#include "mylist.h"
}
// BASIC 4

// Default constructor 

StrList::StrList(){
	//list = {0};
	// isEmpty utilizes (List *)
	initList((List*) &list); 
}

// Constructor

StrList::StrList(const StrList *sl){ 	
	//cout << "non-def constructor" << endl;
	list = sl->list;
}

// Destructor 

StrList::~StrList(){
	// Clear entire linked list by freeing all nodes
	// DELETE everything you created from other functions too
	struct Node *node = list.head;
	while(node){
		// From copy constructor we used (MyString*) to add data
		// Parenthesis needed and forgot to put next node
		delete (MyString*)(node->data);
		node = node->next;
	}
	// Need to remove underlying list
	removeAllNodes(&list);
	
}

// Copy Constructor - Must pass its first arg by reference

StrList::StrList(const StrList &sl){
	//Citation: http://stackoverflow.com/questions/7811893
	// /creating-a-copy-constructor-for-a-linked-list
	// Helped clarify shallow copy vs deep copy in this situation
	initList((List*)&list); // Empty out data member (list.head = 0)
	
	// Must copy all nodes into StrList object copy
	
	//int m = sl.size();	
	// Reverse list, add elements using addfront, reverse it again
	struct Node *node = sl.list.head;
	//struct Node *emptyList = list.head;

	while(node){
		MyString *p = (MyString*)node->data;
		//cout << "data: " << *p << endl;
		this->addFront(*p);

		node = node->next;		
	}
	this->reverse();
}

// END OF BASIC 4

// OPERATORS (RELATIONAL, CONDITIONAL, ETC)

// operator + (Not a member function)

StrList operator+(const StrList &sl, const StrList &sl2){
	StrList temp(sl);
	temp += sl2;
	return temp;
}

StrList& StrList::operator=(const StrList &sl){
	//Empty out 'this', add nodes from sl, reverse
	if (this == &sl){
		return *this;
	}	
	// Why did I get error using this first? Forgot to set
	// if statement for l1 == l1 is true
	removeAllNodes(&list);
	//int counter = 0;
	StrList copy(sl);
	struct Node *node = copy.list.head;
//	int k = sl.size();
//	cout << "size of sl in op=:" << k << endl;
//	cout << "before while" << endl;
	while (node){
		//cout << "before *p and addfront" <<endl;
		MyString *p = (MyString*)node->data;
		this->addFront(*p);
		//counter++;
		//cout<<counter<<endl;
		node = node->next;
	}
	this->reverse();
	
	return *this;
}


// operator +=

StrList& StrList::operator+=(const StrList &sl){

	this->reverse();
	struct Node *node = sl.list.head;
	while(node){
		MyString *p = (MyString*)node->data;
		this->addFront(*p);
		
		node = node->next;
	}
	this->reverse();
	return *this;	
}

void StrList::printHead() const{
	MyString *p = (MyString *) list.head->data;
	cout << "head: " << *p << endl;
}

// operator << (put to)

ostream& operator<<(ostream &os,const StrList &sl){

	struct Node *node = sl.list.head;
	while(node){
		MyString *p = (MyString*)node->data;
		os << *p << " ";
		node = node->next;
	}
	return os;

}

// operator []
MyString& StrList::operator[](int i){
	struct Node *node = list.head;
	int j = 0;
	while(node){
		if ( j == i){
			MyString *copy = (MyString*) node->data;
			return *copy;
		}
		j += 1;
		node = node->next;
	}
	MyString *temp = new MyString();
	cout << "temp returned" << endl;
	return *temp; 
}

// operator [] with const
const MyString& StrList::operator[](int i) const{
	// Like above, but must cast away constness of mystring
	//MyString *s = this[i];
	//return *s;//((MyString&)*this)[i];  //remove constness
	struct Node *node = list.head;
    int j = 0;
    while(node){
        if ( j == i){
            MyString *copy = (MyString*) node->data;
            return *copy;
        }
        j += 1;
        node = node->next;
    }
    MyString *temp = new MyString();
    cout << "temp returned" << endl;
    return *temp;
}
// END OF OPERATORS

// WRAPPED MEMBER FUNCTIONS

// size()
int StrList::size() const{
	// traverse list, keep count, return count number
	int size = 0;
	struct Node *node = list.head;
	while(node){
		size +=1;
		node = node->next;
	}
	// Should free
	return size;

}

// addFront (l1.addFront("2");)
StrList& StrList::addFront(const MyString &sl) {//const{

	MyString *copy = new MyString(sl);
	::addFront(&list, copy);
	//delete copy;
	//free(copy);
	
	// modify List 'list'
	//MyString* p = (MyString *) list.head->data;
	// WORKS!
	//cout << "after addfront: " << *p << endl;
	return *this;
}

void StrList::addBack(const MyString &sl){
	MyString *copy = new MyString(sl);
	::addBack(&list, copy);
}

// popFront() (

MyString& StrList::popFront(){// const{

	// Create object copy of popped node
	MyString *pop = (MyString*)::popFront(&list);
	// Create MyString return copy using that copy
	MyString *copy = new MyString(*pop);
	//free(pop);
	return *copy;
}

// reverse() not included, already written in header file
