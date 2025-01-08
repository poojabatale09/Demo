package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConsoleLogCapturer;
import utils.TestContextSetup;

public class Hooks {
TestContextSetup testContextSetup;

private ConsoleLogCapturer logCapturer;

//new code has been added by pooja B

private static final Logger logger = LogManager.getLogger(Hooks.class);
	
	public Hooks(TestContextSetup testContextSetup)
	{
		
		this.testContextSetup = testContextSetup;
	}
	
	@Before	
	public void beforeScenario() {
        // Initialize log capturing and start writing to the log file
        logCapturer = new ConsoleLogCapturer("test-logs.txt");  // Log file name
        logger.info("Starting the scenario...");
    }

	
	@After
	public void AfterScenario() throws IOException
	{
		logger.info("Ending the scenario...");
        // Stop capturing and reset the output stream
        logCapturer.stopCapturingLogs();
		testContextSetup.testBase.WebDriverManager().quit();
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver =testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		logger.info("Screenshot has been added");
		
		}
		
	}
	
}
