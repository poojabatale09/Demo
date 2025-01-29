package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.TestContextSetup;

public class PaginationPage {
	
WebDriver driver;


	
	public PaginationPage(WebDriver driver)
	{
		
		this.driver = driver;
		
		
	}
	
	By mainTable = By.id("example_wrapper");
	
	 // Locator for the "Name" column header
    private By nameColumnHeader = By.xpath("(//span[text()='Name'])[1]");

    // Locator for rows in the table (assuming there is a <table> element)
    private By tableRows = By.xpath("//table[@id='example']//tbody/tr");

    // Locator for values in the "Name" column
    private By nameColumnValues = By.xpath("//table[@id='example']//tbody/tr/td[1]");

	
	
	public WebElement scrollToMainTable()
	{
		
		return driver.findElement(mainTable);
	}
	
	 // Method to get the "Name" column header WebElement
    public WebElement getNameColumnHeader() {
        return driver.findElement(nameColumnHeader);
    }

    // Method to get all the rows in the table (based on "Name" column)
    public int getRowCount() {
        return driver.findElements(tableRows).size();
    }

    // Method to get the values in the "Name" column
    public List<WebElement> getNameColumnValues() {
        return driver.findElements(nameColumnValues);
    }

    // Method to click on the "Name" column header to sort
    public void clickOnNameColumnHeader() {
        driver.findElement(nameColumnHeader).click();
    }
    
    // Method to check if the values in the "Name" column are sorted in ascending order
    public boolean isSortedAscending() {
        List<WebElement> nameValues = getNameColumnValues();
        for (int i = 0; i < nameValues.size() - 1; i++) {
            if (nameValues.get(i).getText().compareTo(nameValues.get(i + 1).getText()) > 0) {
                return false;  // Not in ascending order
            }
        }
        return true;
    }

    // Method to check if the values in the "Name" column are sorted in descending order
    public boolean isSortedDescending() {
        List<WebElement> nameValues = getNameColumnValues();
        for (int i = 0; i < nameValues.size() - 1; i++) {
            if (nameValues.get(i).getText().compareTo(nameValues.get(i + 1).getText()) < 0) {
                return false;  // Not in descending order
            }
        }
        return true;
    }
	

}
