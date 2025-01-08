package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.SearchFlightPage;
import utils.TestContextSetup;



public class SearchFlightStepDefinition {
	
	TestContextSetup testContextSetup;
	public SearchFlightPage searchFlightPage;
	private static final Logger logger = LogManager.getLogger(SearchFlightStepDefinition.class);
	
	public SearchFlightStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.searchFlightPage = testContextSetup.pageObjectManager.getsearchFlightPage();
	}
	
	
	
	@When("user clicks on Flight Booking link")
	public void user_clicks_on_flight_booking_link() throws InterruptedException {
		
		searchFlightPage.selectFlightBooking();
		logger.info("user clicks on Flight Booking link");
	}

	@Then("user navigates to new window for flight booking")
	public void user_navigates_to_new_window_for_flight_booking() {
		
		testContextSetup.genericUtils.SwitchWindowToChild();
		logger.info("user navigates to new window for flight booking");
	}
	
	@Then("user selects country {string} from the dropdwon.")
	public void user_selects_country_from_the_dropdwon(String name) {
		searchFlightPage.enterCountry(name);
		logger.info("Country name entered");
	}
	
	@Then("user selects RoundTrip Radio")
	public void user_selects_round_trip_radio() {
	    searchFlightPage.selectRoundTripRadio();
	}
	
	@Then("user enters all the details with From {string}, To {string}")
	public void user_enters_all_the_details_with_from_to_depart_date_and_return_date(String strFrom, String strTo) {
	 
		searchFlightPage.enterFromCity(strFrom);
		searchFlightPage.enterToCity(strTo);
		
	}

	@Then("user clicks on Family and Friends checkbox")
	public void user_clicks_on_family_and_friends_checkbox() {
	    
	}

	@Then("user clicks on Search button")
	public void user_clicks_on_search_button() {
	    
	}

}
