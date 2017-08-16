C  = gcc
CXX = g+

#Compiler values for C

INCLUDES =

CFLAGS   = -g -Wall $(INCLUDES)
CXXFLAGS = -g -Wall $(INCLUDES)

#Checks for warnings and compilation errors

LDFLAGS = -g

LDLIBS =

#g is for debugging

#Actual code

mylist-test: mylist-test.o libmylist.a # mylist-test.o mylist.o #gcd.o

libmylist.a: mylist.o
	ar rc libmylist.a mylist.o

mylist-test.o : mylist-test.c mylist.h #gcd.h

mylist.o: mylist.c mylist.h

#Phony targets for cleaning directory/memory leaks
.PHONY : clean
clean :
	rm *.a *.o mylist-test
.PHONY: all
all:
	clean mylist-test
.PHONY: valgrind
valgrind: mylist-test
	valgrind --leak-check=full ./mylist-test >> ../README.txt 2>&1
