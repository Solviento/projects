//ABSTRACT CLASS AND ABSTRACT METHOD
public abstract class BankAccount {

	protected int balance;
	
	public int getBalance(){
		return balance;
	}
	
	public abstract void withdraw(int amount);
	
	
}
