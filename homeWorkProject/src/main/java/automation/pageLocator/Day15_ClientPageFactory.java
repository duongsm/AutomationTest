package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day15_ClientPageFactory {

	@FindBy(xpath = "(//span[@class = 'menu-text '])[2]")
	private WebElement linkClient;

	@FindBy(xpath = "//a[@title = 'Add client']")
	private WebElement btnAddClient;

	@FindBy(id = "type_organization")
	private WebElement radioOrganization;

	@FindBy(id = "type_person")
	private WebElement radioPerson;

	@FindBy(xpath = "//input[@id = 'company_name']")
	private WebElement txtCompany;

	@FindBy(id = "s2id_created_by")
	private WebElement dropdownOwner;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "city")
	private WebElement txtCity;

	@FindBy(id = "state")
	private WebElement txtState;

	@FindBy(id = "zip")
	private WebElement txtZip;

	@FindBy(id = "country")
	private WebElement txtCountry;

	@FindBy(id = "vat_number")
	private WebElement txtVat_number;

	@FindBy(id = "gst_number")
	private WebElement txtGst_number;

	@FindBy(id = "s2id_autogen2")
	private WebElement txtClient_group;

	@FindBy(id = "select2-chosen-1")
	private WebElement dropdownCurrency;

	@FindBy(id = "currency_symbol")
	private WebElement txtCurrency_symbol;

	@FindBy(id = "s2id_client_labels")
	private WebElement txtLabel;

	@FindBy(id = "disable_online_payment")
	private WebElement checkboxDisable_online_payment;

	@FindBy(xpath = "//button[@class = 'btn btn-primary']")
	private WebElement btnSaveAndClose;

	private WebDriver driver;

	public Day15_ClientPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddClient(String company) {
		linkClient.click();
//		btnAddClient.click();
		((JavascriptExecutor) driver).executeScript("arguments [0].click();", btnAddClient);
		txtCompany.sendKeys(company);
		btnSaveAndClose.click();
	}
}
