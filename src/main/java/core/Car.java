package core;

/*
 * @author nikhilbhardwaj01
 */


public class Car {
	String carModel;
	CarType carType;
	double carPrice;
	InsuranceType insuranceType;
	double premiumAmountBasedOnCarType;
	double effectivePremiumAmount;

	public void setCarDetails(String carModel, CarType carType, double carPrice, InsuranceType insuranceType) {
		this.carModel = carModel;
		this.carType = carType;
		this.carPrice = carPrice;
		this.insuranceType = insuranceType;

	}
	
	public double getPremiumAmountBasedOnCarType() {
		return this.premiumAmountBasedOnCarType;
	}
	
	public double getEffectivePremiumAmount() {
		return this.effectivePremiumAmount;
	}
	
	

	@Override
	public String toString() {
		return "Car [carModel=" + carModel + ", carType=" + carType + ", carPrice=" + carPrice + ", insuranceType="
				+ insuranceType + ", premiumAmountBasedOnCarType=" + premiumAmountBasedOnCarType
				+ ", effectivePremiumAmount=" + effectivePremiumAmount + "]";
	}

	public void calculatePremiumBasedOnCarType() {
		switch (this.carType) {

		case HATCHBACK: {
			this.premiumAmountBasedOnCarType = (this.carPrice * 5) / 100;
			break;
		}

		case SEDAN: {
			this.premiumAmountBasedOnCarType = (this.carPrice * 8) / 100;
			break;
		}

		case SUV: {
			this.premiumAmountBasedOnCarType = (this.carPrice * 10) / 100;
			break;
		}

		}

	}

	public void calculateEffectivePremium() {
		switch (this.insuranceType) {
		case BASIC: {
			this.effectivePremiumAmount = this.premiumAmountBasedOnCarType;
			break;
		}

		case PREMIUM: {
			this.effectivePremiumAmount = this.premiumAmountBasedOnCarType
					+ (this.premiumAmountBasedOnCarType * 20) / 100;
			break;
		}
		}

	}

	public void displayOutput() {
		System.out.println();
		System.out.println("\t\t\t ####################### Output #######################");
		System.out.println();
		System.out.println("\t\t\t\t\t Car Model: " + this.carModel);
		System.out.println("\t\t\t\t\t Car Price: INR " + String.format("%.2f", this.carPrice));
		System.out.println(
				"\t\t\t\t Total Insurance to be paid: INR " + String.format("%.2f", this.effectivePremiumAmount));
		System.out.println();
		System.out.println("\t\t\t #######################################################");
		System.out.println();
	}
}
