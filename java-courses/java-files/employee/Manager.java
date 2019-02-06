
public class Manager extends Employee {

	private int bonus;
	
	public Manager(String name, int salary, int bonus){

		//Invoke constructor of the Superclass
		super(name, salary);
		this.bonus = bonus;
	}
	
	public int getBonus(){
		return bonus;
	}
	
	public void setBonus(int newBonus){
		bonus = newBonus;
	}
	
	// Override method
	public int getTotalCompensation(){
		return super.getTotalCompensation() + bonus;
	}
	
	
}
