package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement fname;
	
	  By firstName = By.xpath("//input[@placeholder='First Name']");
	  By lastName = By.xpath("//input[@placeholder='Last Name']");
	  
	  
	  By email = By.xpath("//input[@type='email']");
	  By telephone = By.xpath("//input[@type='tel']");
	  
	  By radioFemale = By.xpath("//input[@type='radio' and @value='FeMale']");
	  By dropdown_options = By.xpath("//li[@class='ng-scope']//a[text()='Dutch']");
	  
	  By drpContry = By.xpath("//span[@class='selection']");
	  
	  By ipContrySearch = By.xpath("//input[@type='search']");
	  
	  
	  
	  By firstpassword = By.id("firstpassword");
	  By secondpassword = By.id("secondpassword");
	  
	  By btnSubmit = By.id("submitbtn");
	  
	  
public void fillRegistrationForm(String strfname, String strlname, String stremail, String phoneNumber,
              String strgender, String strcountry, String strpassword, String strconfirmPassword)	  
{
		fname.sendKeys(strfname);
		driver.findElement(lastName).sendKeys(strlname);
		driver.findElement(email).sendKeys(stremail);
		driver.findElement(telephone).sendKeys(phoneNumber);
		
		driver.findElement(radioFemale).click();
		
		
		driver.findElement(firstpassword).sendKeys(strpassword);
		driver.findElement(secondpassword).sendKeys(strconfirmPassword);
		
		

}

//Action to submit the registration form
public void submitForm() {
	driver.findElement(btnSubmit).click();
}

	 

}
