package exceptions;

/*
 * @author nikhilbhardwaj01
 */
public class UnRealisticCarPriceException extends Exception implements ExceptionInterface {
	public UnRealisticCarPriceException() {
		super();
	}

	public void displayMessage() {
		System.out.println("\t\t\t Please Be Realistic...Do Not Enter Imaginary Prices.");
	}
}
