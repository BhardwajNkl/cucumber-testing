package exceptions;

/*
 * @author nikhilbhardwaj01
 */
public class InvalidInsuranceTypeException extends Exception implements ExceptionInterface {
	public InvalidInsuranceTypeException() {
		super();
	}

	public void displayMessage() {
		System.out.println("\t\t\t Invalid Insurance Type Chosen! Please Enter Again.");
	}
}
