package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pageobjects.TravelQuotePO;

public class Steps {

	WebDriver driver;
	TravelQuotePO TravelQuotePO;

	@After
	public void quitBrowser() {
		driver.quit();
	}

	@Given("^I am a customer$")
	public void IAmACustomer() throws Throwable {

		try {

			System.out.println(System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

			// Open Post Office Application
			driver.get("https://www.postoffice.co.uk/travel-insurance");

			// Wait for the page to load
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			// Maximize browser
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("^I try to get a single trip travel quote")
	public void ITryToGetASingleTripTravelQuote() {
		try {

			// Trip Details Page
			
			Reporter.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshots");

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			/*
			 * TravelQuotePO travelQuotePO = new TravelQuotePO(driver);
			 * travelQuotePO.fillTripDetailsForm();
			 */

			driver.findElement(By.cssSelector(
					"#maincontent > div.brace.category-header.theme.bg.margin-bottom.theme-berry > div > div.poster > div > section > div > ul > li > a"))
					.click();

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div.mg-top-20 > div:nth-child(1) > div > div > fieldset > div > div > div:nth-child(1) > label > span > span:nth-child(2)"))
					.click();

			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div.mg-top-20 > div:nth-child(2) > div > div > fieldset > div > div > div:nth-child(1) > label > span > span:nth-child(2)"))
					.click();

			((JavascriptExecutor) driver).executeScript(
					"document.getElementById('Policies_0__TripStartDate').removeAttribute('readonly',0);");

			driver.findElement(By.id("Policies_0__TripStartDate")).sendKeys("20/10/2017");

			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('Policies_0__TripEndDate').removeAttribute('readonly',0);");

			driver.findElement(By.id("Policies_0__TripEndDate")).sendKeys("27/10/2017");

			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div.mg-top-20 > div:nth-child(5) > div:nth-child(2) > div > div.col-xs-offset-2.col-sm-offset-5.col-md-offset-5 > div > label:nth-child(1) > span"))
					.click();

			driver.findElement(By.id("Policies_0__Risk_0__Traveller_DateOfBirth")).sendKeys("20/12/1988");

			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div.mg-top-20 > div:nth-child(9) > div > div > div.col-xs-offset-4.col-sm-offset-5.col-md-offset-5 > div > label:nth-child(2) > span"))
					.click();

			driver.findElement(By.id("tripdeatails-next")).click();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	@Then("^I should be able to generate the quote successfully")
	public void IShouldBeAbleToGenerateTheQuoteSuccessfully() {

		try {

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.findElement(By.cssSelector("#select_Single_SuperEconomy")).click();

			Thread.sleep(5000);

			driver.findElement(By.cssSelector("#additionalcovers-next")).click();

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.findElement(By.id("Policies_0__Risk_0__Traveller_FirstName")).sendKeys("Automation");
			driver.findElement(By.id("Policies_0__Risk_0__Traveller_LastName")).sendKeys("Tester");
			driver.findElement(By.id("Account_PrimaryPhone")).sendKeys("07598763544");

			driver.findElement(By.id("Account_Email")).sendKeys("automation.tester@gmail.com");
			driver.findElement(By.cssSelector("#address-lookup > div > div:nth-child(7) > div > div > button")).click();

			driver.findElement(By.id("Account_Address_Line1")).sendKeys("242");
			driver.findElement(By.id("Account_Address_Line2")).sendKeys("King Street");

			driver.findElement(By.id("Account_Address_City")).sendKeys("Norwich");

			driver.findElement(By.id("Account_Address_County")).sendKeys("Norfolk");

			driver.findElement(By.id("Account_Address_PostCode")).sendKeys("NR12BU");

			Select dropdown = new Select(driver.findElement(By.id("Account_MarketingContactType")));

			dropdown.selectByIndex(3);

			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div:nth-child(19) > div > div > div > div.col-md-1.col-sm-1.col-xs-2.no-padding > label > span"))
					.click();
			driver.findElement(By.cssSelector(
					"#form > div.panel.panel-default > div > div:nth-child(20) > div > div > div > div.col-md-1.col-sm-1.col-xs-2.no-padding > label > span"))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
