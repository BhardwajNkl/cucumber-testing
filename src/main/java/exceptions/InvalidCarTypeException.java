package exceptions;

/*
 * @author nikhilbhardwaj01
 */
public class InvalidCarTypeException extends Exception implements ExceptionInterface {
	public InvalidCarTypeException() {
		super();
	}

	public void displayMessage() {
		System.out.println("\t\t\t Invalid Car Type Chosen! Please Enter Again.");
	}
}
