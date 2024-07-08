Feature: Premium Amount Calculation
	Scenario: premium amount should be calculated based on car type
		Given I am on the application prompt
		When I enter carModel as "car001"
			And I enter carType as "HATCHBACK"
			And I enter carPrice as 100000
			And I enter insuranceType as "BASIC"
		Then The premium amount based on car type should be 5000
		
		When I enter carModel as "car002"
			And I enter carType as "SEDAN"
			And I enter carPrice as 100000
			And I enter insuranceType as "PREMIUM"
		Then The premium amount based on car type should be 8000
		
		When I enter carModel as "car003"
			And I enter carType as "SUV"
			And I enter carPrice as 100000
			And I enter insuranceType as "BASIC"
		Then The premium amount based on car type should be 10000
		
	Scenario: effective premium amount should be calculated
		Given I am on the application prompt
		When I enter carModel as "car001"
			And I enter carType as "HATCHBACK"
			And I enter carPrice as 100000
			And I enter insuranceType as "BASIC"
		Then The effective premium amount should be 5000
		
		When I enter carModel as "car001"
			And I enter carType as "HATCHBACK"
			And I enter carPrice as 100000
			And I enter insuranceType as "PREMIUM"
		Then The effective premium amount should be 6000
		
		When I enter carModel as "car002"
			And I enter carType as "SEDAN"
			And I enter carPrice as 100000
			And I enter insuranceType as "PREMIUM"
		Then The effective premium amount should be 9600
		
		When I enter carModel as "car003"
			And I enter carType as "SUV"
			And I enter carPrice as 100000
			And I enter insuranceType as "BASIC"
		Then The effective premium amount should be 10000
		
		When I enter carModel as "car003"
			And I enter carType as "SUV"
			And I enter carPrice as 100000
			And I enter insuranceType as "PREMIUM"
		Then The effective premium amount should be 12000
		