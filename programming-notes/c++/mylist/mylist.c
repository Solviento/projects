     #include <stdio.h>
#include <stdlib.h>
#include "mylist.h"


int compareDouble(const void *data1, const void *data2){

	//Cast as double, implement comparisons	
	const double *a = (const double *)data1;
	const double *b = (const double *)data2;
	
	if ( (*a == *b)  ){
		return 0;
	}
	else{
		return 1;
	}
}


struct Node *addFront(struct List *list, void *origdata){

	//*ptr will dereference and obtain the actual data 
	//pointed to by the pointer
	//ptr will obtain the memory address of the pointer 
	//itself (8 bytes)

	struct Node *push = malloc(sizeof(*push));
	push -> data = origdata;
	
	//Push node into list by changing next pointers
	//and setting head node to push node

	if ( (list -> head  == 0) ){
	
		(push -> next) = (list -> head);
		list -> head  = push;
		return (list -> head);
	}
	else{
		(push -> next) = (list -> head);
		
		list -> head = push;
		return (list -> head);
	}
}

void traverseList(struct List *list, void (*f)(void *)){
	
	//Iterate through list, implement given *f function
	struct Node *tempNode = (list -> head);
	
	while ( (tempNode != 0) ){
	
		f(tempNode -> data);
		tempNode = (tempNode -> next);
	}
}

struct Node *findNode(struct List *list, const void *dataSought,
 int (*compar)(const void *, const void *)){
		
	//Iterate through list, compare data, implement return
	//if found
	struct Node *tempNode = (list -> head);

	while( (tempNode != 0) ){
		
		int val = compar( (tempNode -> data), dataSought);
		if (val == 0){
			return tempNode;
		}
		tempNode = (tempNode -> next);
	}
	//Data not found, return NULL
	return NULL;
	
}

void flipSignDouble(void *data){

	//Access data, cast as double, negate data
	//Set as new data
	double *a = (double *)data;
	
	*a = (*a) * -1.0;
	data = a;
}

void *popFront(struct List *list){

	//Cut head's next pointer from rest of linked list
	//Deallocate memory for head's data
	//Set head's next pointer as new head node
	//If condition return NULL if list is empty
	
	if ( (list -> head == 0) ){
		return NULL;
	}
	else{
		void *data = (list -> head -> data);
		struct Node *h = (list -> head -> next);

		free(list -> head);
		(list -> head) = h;
		
		return (data);
	}
}

void removeAllNodes(struct List *list){
	//Implement popfront until list is empty
	while( list -> head != 0){
		popFront(list);
	}
}

struct Node *addAfter(struct List *list,
         struct Node *prevNode, void *newdata){
	
	//Iterate through list, if selected node's data matches
	//that of prevNode'data, implement push and switch
	//algorithm from addFront

	if (prevNode == NULL){

		(list->head) = malloc(sizeof(*(list->head)));
		(list->head->data) = newdata;
		(list->head->next) = 0;

		return(list->head);
	}	
	else {
		struct Node *tempNode = (list -> head); //prevNode;
		struct Node *new = malloc(sizeof(*new));
		new->data = newdata;

		while (tempNode != 0){
			
			if ( (tempNode -> data) == (prevNode -> data) ){
			
				new->next = tempNode->next;
				tempNode->next = new;
				return(tempNode->next);
			}
			tempNode = (tempNode -> next);
		}
		//No match found in list
		return NULL;
	}
}	

//Used image from website to better understand how to implement algorithm
//Citation: http://www.geeksforgeeks.org/wp-content/uploads/2009/
//07/Linked-List-Rverse.gif

void reverseList(struct List *list){

	//Our prv and nxt are in NULL space
	struct Node *prv = NULL;
	struct Node *cur = (list->head);
	struct Node *nxt = NULL;
	
	while (cur){
		//manipulate cur (which is head node of list)
		nxt = cur->next;
		cur->next = prv;
		prv = cur;
		cur = nxt;	
	}
	(list->head) = prv;
	//Set last node as head, next pointers should be alligned properly
}


