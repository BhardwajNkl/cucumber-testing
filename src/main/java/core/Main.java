/**
 * 
 */

package core;

import java.util.Scanner;

import exceptions.InvalidCarTypeException;
import exceptions.InvalidInsuranceTypeException;
import exceptions.UnRealisticCarPriceException;

/**
 * @author nikhilbhardwaj01
 *
 */

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		String response = "y"; // to know whether the user wants to enter other car details.
		Scanner sc = new Scanner(System.in); // Scanner object for reading inputs
		System.out.println();
		System.out.println("\t\t=============== Car Insurance Premium Calculator ===============");
		System.out.println();

		do {
			start();
			System.out.print("\t\t\t Do you want to enter details of any other car(Y/N)? ");
			response = sc.next();
		} while (response.equalsIgnoreCase("y"));
		System.out.println();
		System.out.println();
		System.out.println("\t\t============================ Thank You ============================");
		System.out.println();

		sc.close();

	}

	static void start() {
		String carModel = null;// for storing the model name entered by the user
		String carType = null;// for storing the car type value entered by the user
		String carPriceString = null;// taking the price as a string for handling exceptional cases well.
		double carPrice = 0; // stores the actual numeric value of price entered by the user. It gets the
								// value from carPriceString
		String insuranceType = null;// stores the type of insurance entered by the user

		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\t||Enter Car Details|| ");
		System.out.println();
		System.out.print("\t\t\t Car Model>> ");
		carModel = sc.nextLine();

		boolean validCarType = false;// this is used for exception handling. Program prompts the user to enter valid
										// car type value Until the user enters a valid choice.
		while (!validCarType) {

			System.out.print("\t\t\t Car Type(Hatchback/Sedan/SUV)>> ");
			carType = sc.nextLine();
			carType = carType.toUpperCase();
			try {
				for (CarType ct : CarType.values()) {
					if (ct.name().equals(carType)) {
						validCarType = true;
						break;
					}
				}

				if (!validCarType) {
					throw new InvalidCarTypeException();
				}

			} catch (InvalidCarTypeException e) {
				e.displayMessage();
			}
		}

		boolean validPriceValue = false; // this is used for exception handling. Program prompts the user to enter a
											// valid and possible car price value Until the user enters a valid price.
		while (!validPriceValue) {

			System.out.print("\t\t\t Car Price(INR)>> ");
			carPriceString = sc.nextLine();
			try {
				if (carPriceString.length() > 10) {
					// car price string having more than 10 characters means that the entered price
					// will be more than or equal to 1000 crore rupees which is quite unrealistic
					throw new UnRealisticCarPriceException();
				}
				carPrice = Double.parseDouble(carPriceString);
				if (carPrice < 0) {
					throw new UnRealisticCarPriceException();
				}
				validPriceValue = true;
			} catch (UnRealisticCarPriceException e) {
				e.displayMessage();
			} catch (NumberFormatException nfe) {
				System.out.println("\t\t\t Please enter a valid value for price.");
				validPriceValue = false;
			}
		}

		boolean validInsuranceType = false;// this is used for exception handling. Program prompts the user to enter
											// valid insurance type Until the user enters a valid choice.
		while (!validInsuranceType) {

			System.out.print("\t\t\t Insurance Type(Basic/Premium)>> ");

			insuranceType = sc.nextLine();
			insuranceType = insuranceType.toUpperCase();
			try {
				for (InsuranceType it : InsuranceType.values()) {
					if (it.name().equals(insuranceType)) {
						validInsuranceType = true;
						break;
					}
				}
				if (!validInsuranceType) {
					throw new InvalidInsuranceTypeException();
				}
			} catch (InvalidInsuranceTypeException e) {
				e.displayMessage();
			}
		}

		Car c = new Car();// creating a Car object.
		c.setCarDetails(carModel, CarType.valueOf(carType), carPrice, InsuranceType.valueOf(insuranceType));

		// displaying the result
		c.calculatePremiumBasedOnCarType();
		c.calculateEffectivePremium();
		c.displayOutput();

	}

}
