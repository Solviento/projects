
public class Employee { //SUPERCLASS

	private String name;
	private int salary;
	
	
	// Constructor Method
	public Employee(String name, int salary){
		
		this.name = name;
		this.salary = salary;
		
	}
	
	// Accessor Methods
	
	public String getName(){
		return name;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public int getTotalCompensation(){
		return salary;
	}
	
	// Mutator Method
	
	public void setSalary(int newSalary) {

		salary = newSalary;

	}
	
}
