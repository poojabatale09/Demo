package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;
import utils.TestContextSetup;

public class SearchFlightPage {
	
	public WebDriver driver;
	
	
	public SearchFlightPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By flightBooking = By.xpath("//a[text()='Flight Booking']");
	By country = By.xpath("//input[@id='autosuggest']");
	By rounTipRadio = By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']");
	By fromCity = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	By fromToCity = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
	By departDate = By.xpath("//input[@id='ctl00_mainContent_view_date1']");
	By returnDate = By.xpath("//input[@id='ctl00_mainContent_view_date2']");
	By searchBtn = By.xpath("//input[@value='Search']");
	
	public void selectFlightBooking() throws InterruptedException
	{
		driver.findElement(flightBooking).click();
		Thread.sleep(5000);
		
	}
	
	public void enterCountry(String name)
	{
		driver.findElement(country).sendKeys(name);
		driver.findElement(country).sendKeys(Keys.DOWN);
		driver.findElement(country).sendKeys(Keys.RETURN);
	}
	
	public void selectRoundTripRadio()
	{
		driver.findElement(rounTipRadio).click();
	}
	
	public void enterFromCity(String strFromCity)
	{
		driver.findElement(fromCity).click();
		driver.findElement(fromCity).sendKeys(strFromCity);
	}
	
	public void enterToCity(String strToCity)
	{
		driver.findElement(fromToCity).click();
		driver.findElement(fromToCity).sendKeys(strToCity);
	}
		
	
	
	

}
