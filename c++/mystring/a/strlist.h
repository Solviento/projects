/* strlist.h */
#ifndef __STRLIST_H__
#define __STRLIST_H__
/*
   Copy the mystring.h/cpp files from lab9/solutions directory.
 */
#include "mystring.h"
/*
   Note that extern "C" is required when you are linking with an
   object file or a library compiled in C from C++.
   Use the usual -I, -L, -l flags in your Makefile to link with
   libmylist.a in your lab3/solutions directory.  Do NOT copy over
   any of the old linked list files into lab10 directory.
 */
extern "C" {
#include "mylist.h"
}

class StrList {

    public: // BASIC 4
		// print Head Node
		void printHead() const;
		
		// Default Constructor	
       	StrList();

		// Constructor
		StrList(const StrList *sl);

		// Destructor
		~StrList();

		// Copy constructor, must always have const IMPORTANT
		StrList(const StrList &s1);
        // isEmpty() function
        /*
           I'm giving away this function to show you that you'll have
           to cast away the const-ness of the data member when
           necessary.
         */
        int isEmpty() const { return isEmptyList((List *)&list); }

        // TODO: size() function
        // returns the number of nodes in the list
		int size() const; // const; //(List *) &list, void (*f) (void *));
			// Will try to implement traverseList

        // TODO: addFront() function
        // adds a string to the front of the list
        /*
           Note that in order to call the global addFront() function
           (which has the same name with the member function that
           you're writing) you have to append "::" in front, as in
           "::addFront(&list, ......)".
         */
		// StrList l1;
		// l1.addFront("0"); - input is MyString/String literal
		
		StrList& addFront(const MyString &s1);
		void addBack(const MyString &s1); 

        // TODO: popFront() function 
        // Pops a string from the front of the list and returns it.
        // The result of popping from an empty list is undefined.
		MyString& popFront();// const;

        // TODO: reverse() function
        // reverse the elements in the list
		void reverse() const{ return reverseList( (List *) &list); }
	
		// Not TODO: but required anyway	
		StrList& operator=(const StrList &sl);

        // TODO: operator+= (adding two StrList objects together)
        // The result of "sl += sl" is undefined.
		StrList& operator+=(const StrList &s1);

        // TODO: operator+ (shouldn't this be outside?
		//StrList operator+(StrList s1);

		//StrList operator=(StrList sl);

        // TODO: operator<<
        // Prints the content of the given list in the following
        // format: 
        //
        //     { one two three }
        // 
        // assuming you had the three strings ("one", "two", "three")
        // in the list.
		friend ostream& operator<<(ostream &os, const StrList &sl); // Might change reference to os

        // TODO: operator[] 
        // This function takes O(n) time.
        // The result of accessing beyond the last element is undefined.
		MyString& operator[](int i);

        // TODO: operator[] const
        // This function takes O(n) time.
        // The result of accessing beyond the last element is undefined.
		const MyString& operator[](int i) const;
		// Could give error!!

    private:

        // This class contains the old C list structure as its single
        // data member.  Do NOT add any data member.

        struct List list;
};

StrList operator+(const StrList &sl, const StrList &sl2);


#endif
