Feature: Premium Amount Calculation
	Scenario Outline: premium amount based on car type and effective premium should be calculated
		Given I am on the application prompt
		When I enter carModel as "model"
			And I enter carType as "<carType>"
			And I enter carPrice as <price>
			And I enter insuranceType as "<insuranceType>"
		Then The premium amount based on car type should be <premiumAmountBasedOnCarType> and effective premium should be <effectivePremium>
		
		Examples: 
			| carType | price | insuranceType | premiumAmountBasedOnCarType | effectivePremium |
			| HATCHBACK | 100 | BASIC | 5 | 5 |
			| HATCHBACK | 100 | PREMIUM | 5 | 6 |
			| SEDAN | 100 | BASIC | 8 | 8 |
			| SEDAN | 100 | PREMIUM | 8 | 9.6 |
			| SUV | 100 | BASIC | 10 | 10 |
			| SUV | 100 | PREMIUM | 10 | 12 |