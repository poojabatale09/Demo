package stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegistrationPage;
import utils.TestContextSetup;

public class RegistrationStepDefinition {
	
	TestContextSetup testContextSetup;
	public RegistrationPage registrationPage;
	
	public RegistrationStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.registrationPage = testContextSetup.pageObjectManager.getregistrationPage();
	}
	
	@Given("User is on Registration Page")
	public void user_is_on_registration_page() {
	    
	}

	@When("User enters all the valid inputs")
	public void user_enters_all_the_valid_inputs(DataTable dataTable) {
		List<String> userInputs = dataTable.asList();
		
		String firstName = userInputs.get(0);
        String lastName = userInputs.get(1);
        String email = userInputs.get(2);
        String phone = userInputs.get(3);
        String gender = userInputs.get(4);
        String country = userInputs.get(5);
        String password = userInputs.get(6);
        String confirmPassword = userInputs.get(7);
        
        registrationPage.fillRegistrationForm(firstName, lastName, email, phone, gender, country, password, confirmPassword);

	}

	@Then("User clicks on Submit Button")
	public void user_clicks_on_submit_button() {
		registrationPage.submitForm();
	}

	@Then("User registration successful")
	public void user_registration_successful() {
	    
	}

}
