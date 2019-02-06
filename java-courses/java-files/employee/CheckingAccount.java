
public class CheckingAccount extends BankAccount {

	public CheckingAccount (int balance){
		this.balance = balance;
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
}
