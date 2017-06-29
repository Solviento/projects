# Midterm Notes


Java application
- is a complete program that executes when we use the Java command to launch the Java Virtual Machine (JVM)


Java.util.Scanner; is part of a package. Scanner itself is a predefined class that reads input from the user.


classes -> API (Application Programming Interface) -> Java class hierarchy


System.in:
.in -> data source, standard input object, enables application to read bytes if data typed by the user
System -> part of class System.io which is a part of Java.lang


Custom classes
instance variables
Constructor methods
Accessor methods
Mutator methods
static variables, also known as class variables


ex: this.name = name; is an instance variable


strings, input boxes
show input dialog, compose a message and display it
Java coordinate system, width, height
avt package, panel and graphics class
JPanel superclass
Can also take in Graphics as an object
frame class


First assignment will have to do with creating a GUI using code below:



```java
int width = getWidth()
int height = getHeight();
GodrawLine(0, 0, width, line);

drawLine(x1, y1, x2, y2);
drawRectangle(x, y, w, h);
drawOval(x, y, w, h);
drawPolygon(x, y, n); // n - number of sides

DrawPanel panel = new DrawPanel();

application.setDepth...
application.setSize( );
application.add(panel);            
```


import java.art.color;
distribution of color
RGB
(0-255, 0-255, 0-255)


use color constructors

```java
public color(int r, int g, int b);
public color(int rgb);
```
shifting
0xFF000000
(r<<16) &0x00FF0000
page 136 227 556 on color class 


How to find the point
same center
use the radius of the circle inside the pentagon which is partially inside the square


static fields, static methods


static method is a method that belongs to the class and not to the object. 


for any class imported, we can call static methods/fields


scope of the variable


local variables
scope: end of the code block
 
shadowing, what is the shadowing effect? 



```java
public class scope
    private static int x = 1;
    public void static main(String... args){
        int x = 5; // set x = 5
        send x into various methods that change it value to 23, 26, 10... etc
        // however these x values are local so when we call back x in the main method
        system.out.println(x);
        // the value will be 5
    }
```


method overloading


methods are distinguished by their signature


final instance variables

```java
private final int x; // a constant
```
this reference


every object can make a reference to itself with the keyword "this" -> when called for an object, the method implicitly uses the keyword "this" to 



```java
public time{
    private int secs, min, hours;
    //constructors
    public time(){
        this(0,0,0);
    }
    public time(int hours){
        this(hour, 0, 0);
    }
    public time(int hours, int min){
        this(hour, minute, 0);
    }
// GET METHODs
```
static import?


arrays: name, type, memory address
primitive types, reference type
number of consecutive bytes depend on the variable type


all static methods are accessible


class arrays 
    provides static methods for common array questions
    arrays.sort(..)
    .equals


passing an object by reference, passing an object by value
double [] array = new double[24];    
someMethod(array, othervar);    recevies a copy of the reference to array
someMethod(array[4], othervar);    receives a copy of the indexed value


Composition
when objects of one class has references to the objects of other classes


Inheritance
class hierarchy
parent -> child


indirect inheritance


every subclass object (created by inheriting the attributes and methods of an existing superclass) is an object of the superclass


Java does not support multiple inheritance in which a class is derived from more than one class (uses interfaces)


Access modiffiers
Public members are accessible whenever the program has a reference to an object of that class or any of its sub classes
public members are fully inherited in all subclasses in the class hierarchy


private members of a superclass are accessible only within the class itself


protected members, use outside the class hierarchy or package (?), clarification: these variables cannot be modified 


class Object


Object has no fields, has an empty constructor, so it immediately returns controls to the constructor 


object class in package java.temp


constructors are not inherited


the construction of the sublass must implicitly or explicitly call the constructor of the superclass to initialize the instance variables inheritaed by the superclass


2d shape hierarchy


object
|
shape
|                        |    
polygon        oval
|                |                    |
line        triangle        pentagon


In the exercise he will give us will be based on drawing a pentagon


public class Shape{
    private int x, y;
    private Color color;
    public Shape(int x, int y){
        y = y;
        x = y;
    }
    
}
public class Polygon extends Shape{
}


Inheritance -> hierarchy


Polymorphism -> writes programs that process objects that share the same super class either directly or indirectly as if they were objects of the superclass 
-> Programming in the general - the same method applies to a variety of objects and results in many forms of the output
-> Programming in the specific - can determine the type of the object at execution and act with the object accordingly
-> Executibility - new classes can be added to the general portions of the program as long as the new classes are part of the inheritance hierarchy that is processed gradually




















