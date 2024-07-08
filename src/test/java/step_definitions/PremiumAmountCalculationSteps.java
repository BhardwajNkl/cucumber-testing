package step_definitions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import core.Car;
import core.CarType;
import core.InsuranceType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class PremiumAmountCalculationSteps {
	
	
	String carModel;
	String carType;
	Double carPrice;
	String insuranceType;
	
	@Given("I am on the application prompt")
	public void iAmOnTheApplicationPrompt() {
		
	}
	
	@When("I enter carModel as {string}")
	public void enterCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	@When("I enter carType as {string}")
	public void enterCarType(String carType) {
		this.carType = carType;
	}
	
	@When("I enter carPrice as {double}")
	public void enterCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
	@When("I enter insuranceType as {string}")
	public void enterInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	@Then("The premium amount based on car type should be {double}")
	public void verifyPremiumCalculationBasedOnCarType(double expectedAmount) {
		Car car = new Car();
		car.setCarDetails(carModel, CarType.valueOf(carType), carPrice, InsuranceType.valueOf(insuranceType));
		car.calculatePremiumBasedOnCarType();
		double calculated = car.getPremiumAmountBasedOnCarType();
		
		assertEquals(expectedAmount, calculated);
	}
	
	@Then("The effective premium amount should be {double}")
	public void verifyEffectivePremiumCalculation(double expectedAmount) {
		Car car = new Car();
		car.setCarDetails(carModel, CarType.valueOf(carType), carPrice, InsuranceType.valueOf(insuranceType));
		// we need to first calculate the premium amount based on car type. the code is written this way. need a little re-factoring.
		car.calculatePremiumBasedOnCarType();
		car.calculateEffectivePremium();
		double calculated = car.getEffectivePremiumAmount();
		
		assertEquals(expectedAmount, calculated);
	}
	
	
	// for scenario outline file
	@Then("The premium amount based on car type should be {double} and effective premium should be {double}")
	public void verifyPremiumCalculation(double expectedPremiumBasedOnCarType, double expectedEffectivePremium) {
		Car car = new Car();
		car.setCarDetails(carModel, CarType.valueOf(carType), carPrice, InsuranceType.valueOf(insuranceType));
		// we need to first calculate the premium amount based on car type. the code is written this way. need a little re-factoring.
		car.calculatePremiumBasedOnCarType();
		car.calculateEffectivePremium();
		double calculatedPremiumBasedOnCarType = car.getPremiumAmountBasedOnCarType();
		double calculatedEffectivePremium = car.getEffectivePremiumAmount();
		
		assertAll(
				()-> assertEquals(expectedPremiumBasedOnCarType, calculatedPremiumBasedOnCarType),
				()-> assertEquals(expectedEffectivePremium, calculatedEffectivePremium)
				);
	}
	
}
