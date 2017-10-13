package selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TravelQuotePO {

	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#maincontent > div.brace.category-header.theme.bg.margin-bottom.theme-berry > div > div.poster > div > section > div > ul > li > a")
	private WebElement GetAQuoteButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"form\\\"]/div[1]/div/div[2]/div[1]/div/div/fieldset/div/div/div[1]/label/span/span[2]")
	private WebElement singleTripIcon;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"form\\\"]/div[1]/div/div[2]/div[2]/div/div/fieldset/div/div/div[1]/label/span/span[2]")
	private WebElement travelAreaIcon;

	@FindBy(how = How.ID, using = "Policies_0__TripStartDate")
	private WebElement tripStartDate;

	@FindBy(how = How.ID, using = "Policies_0__TripEndDate")
	private WebElement tripEndDate;

	@FindBy(how = How.CSS, using = "#form > div.panel.panel-default > div > div.mg-top-20 > div:nth-child(5) > div:nth-child(2) > div > div.col-xs-offset-2.col-sm-offset-5.col-md-offset-5 > div > label:nth-child(1) > span")
	private WebElement coverForRadioButton;

	@FindBy(how = How.ID, using = "Policies_0__Risk_0__Traveller_DateOfBirth")
	private WebElement dateOfBirthTextbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"form\\\"]/div[1]/div/div[2]/div[9]/div/div/div[2]/div/label[2]/span")
	private WebElement travellersMedicalConditionRadioButton;

	@FindBy(how = How.ID, using = "tripdeatails-next")
	private WebElement nextButton;

	public TravelQuotePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillTripDetailsForm() {

		try {

			// GetAQuoteButton.click();
			
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			singleTripIcon.click();
			travelAreaIcon.click();
			((JavascriptExecutor) driver).executeScript(
					"document.getElementById('Policies_0__TripStartDate').removeAttribute('readonly',0);");
			tripStartDate.sendKeys("20/10/2017");
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('Policies_0__TripEndDate').removeAttribute('readonly',0);");
			tripEndDate.sendKeys("27/10/2017");
			coverForRadioButton.click();
			dateOfBirthTextbox.sendKeys("20/12/1988");
			travellersMedicalConditionRadioButton.click();
			nextButton.click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
