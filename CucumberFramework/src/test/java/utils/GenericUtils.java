package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	
	
	// Wait until an element is visible
    public void waitForElementToBeVisible(WebElement element, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until an element is clickable
    public void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click an element
    public void clickElement(WebElement element) {
        element.click();
    }

    // Send keys to a text field
    public void sendKeysToElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    // Clear a text field
    public void clearTextField(WebElement element) {
        element.clear();
    }

    // Take a screenshot and save it to a specified location
    public void takeScreenshot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Switch to alert and accept it
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Switch to alert and dismiss it
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Get alert text
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Switch to iframe by index
    public void switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // Switch to iframe by name or ID
    public void switchToIframeByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    // Switch back to the main content from iframe
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Select an option from a dropdown by visible text
    public void selectFromDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Select an option from a dropdown by value
    public void selectFromDropdownByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Get selected option from a dropdown
    public String getSelectedOptionFromDropdown(WebElement dropdownElement) {
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }

    // Scroll to an element
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Read data from properties file
    public String readFromPropertiesFile(String key, String propertiesFilePath) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(propertiesFilePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    // Set implicit wait for all elements in the WebDriver
    @SuppressWarnings("deprecation")
	public void setImplicitWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    // Refresh the browser window
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Navigate back in the browser
    public void navigateBack() {
        driver.navigate().back();
    }

    // Navigate forward in the browser
    public void navigateForward() {
        driver.navigate().forward();
    }

    // Get current URL of the page
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    // Get the title of the page
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get the page source
    public String getPageSource() {
        return driver.getPageSource();
    }

    // Quit the driver
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Close the current window
    public void closeWindow() {
        if (driver != null) {
            driver.close();
        }
    }
    
    // Wait for a specific condition
    public boolean waitForCondition(ExpectedCondition<WebElement> condition, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        try {
            wait.until(condition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}
