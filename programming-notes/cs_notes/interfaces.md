#Interfaces

What are interfaces?
- Java interfaces are used to achieve polymorphism. A Java interface can only contain method signatures and fields
- All concrete classes that implement an interface must also implement all methods declared in the interface

Interface example:

public interface ShapeInterface{

	public String send = "Test string";

	public int getArea();

	public int getPoint(int x, int y);

}
