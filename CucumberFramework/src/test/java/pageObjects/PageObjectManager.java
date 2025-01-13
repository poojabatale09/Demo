package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	public SearchFlightPage seachFlightPage;
	public RegistrationPage registrationPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
	
	 landingPage= new LandingPage(driver);
	 return landingPage;
	}
	
	public OffersPage OffersPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	public SearchFlightPage getsearchFlightPage()
	{
		seachFlightPage = new SearchFlightPage(driver);
		return seachFlightPage;
		
	}

	public RegistrationPage getregistrationPage() {
		
		registrationPage = new RegistrationPage(driver);
		return registrationPage;
				
	}
}
