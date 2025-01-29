package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PaginationPage;
import utils.TestContextSetup;

public class PaginationStepDefinition {
	
public TestContextSetup testContextSetup;
public PaginationPage paginationPage;
private static final Logger logger = LogManager.getLogger(PaginationStepDefinition.class);

	
	public PaginationStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;		
		this.paginationPage = testContextSetup.pageObjectManager.getPaginationPage();
	}

	
	@When("user scroll down the page")
	public void user_scroll_down_the_page() throws InterruptedException {
		
		WebElement table = paginationPage.scrollToMainTable();
		testContextSetup.genericUtils.scrollToElement(table);
		Thread.sleep(5000);
	   
	}

	@Then("datatable is displaying")
	public void datatable_is_displaying() {
		Assert.assertTrue(paginationPage.scrollToMainTable().isDisplayed());		
		//assertTrue("The datatable is not displayed on the page", table.isDisplayed());
		logger.info("datatable is displayed");
	    
	}

	@Then("user checks if Name coulmn is sorted ascending by default")
	public void user_checks_if_name_coulmn_is_sorted_ascending_by_default() {
		Assert.assertTrue(paginationPage.isSortedAscending());
		logger.info("datatable is sorted");
		
	    
	}

	@Then("user clicks on Name coulmn and check if Name coulmn is sorted descending.")
	public void user_clicks_on_name_coulmn_and_check_if_name_coulmn_is_sorted_descending() throws InterruptedException {
		paginationPage.clickOnNameColumnHeader();
		Thread.sleep(3000);
		Assert.assertTrue(paginationPage.isSortedDescending());
		logger.info("datatable is sorted");
	    
	}

	

}
