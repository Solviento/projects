/* Credit card class */

public class credit{

	private String card;
	private boolean validity;
	private int errorCode = 0;

	public credit(String cardNumber){
		
		card = cardNumber;
		algorithm(card);
	}
	public void algorithm(String cardNum){

		int[] list = new int[12]; 	// Allocating heap memory for int array
		// Use following ints as verification checks
		int sumEven = 0, sumFirst = 0, sumLast = 0;

		// Dump card number into the int array
		for (int i = 0; i < 12; i++){
			char c = card.charAt(i);
			list[i] = Character.getNumericValue(c);
		}
		// Check for errors
		if (list[0] != 4){
			errors(1);
			return;
		}
		if (list[3] != list[4] +1){
			errors(2);
			return;
		}
		if ( (list[0] * list[4] * list[8]) != 24){
			errors(3);
			return;
		}
		for (int i = 0; i < list.length; i++){
			sumEven += list[i];
		}
		if (sumEven % 4 != 0){
			errors(4);
			return;
		}
		for (int i = 0; i < 4; i++){
			sumFirst += list[i];
		}
		for (int i = 11; i > 7; i--){
			sumLast += list[i];
		}
		if (sumFirst != (sumLast - 1)){
			errors(5);
			return;
		}
		// Convert first two digits to string type then do the same for the 7th and 8th
		// digit - test them after using error checks

		String firstTwo = "";
		String sevenEighth = "";
		
		for (int i = 0; i < 2; i++){
			firstTwo += Integer.toString(list[i]);
		}
		for (int i = 6; i < 8; i++){
			sevenEighth += Integer.toString(list[i]);
		}
		int newFirst = Integer.parseInt(firstTwo);
		int newSecond = Integer.parseInt(sevenEighth);
		if (newFirst + newSecond != 100){
			errors(6);
		}
	}
	// Mutator method: Changes validation value
	public void check(){
		if(errorCode > 0){
			validity = false;
		}
		else{
			validity = true;
		}
	}
	public void errors(int number){
		if (number == 1){
			errorCode = 1;
		}
		if (number == 2) {
			errorCode = 2;
		}
		if (number == 3) {
			errorCode = 3;
		}
		if (number == 4) {
			errorCode = 4;
		}
		if (number == 5) {
			errorCode = 5;
		}
		if (number == 6) {
			errorCode = 6;
		}
	}
	// Accessor methods
	public boolean isValid(){
		return validity;
	}
	public int getErrorCode(){
		return errorCode;
	}
}
