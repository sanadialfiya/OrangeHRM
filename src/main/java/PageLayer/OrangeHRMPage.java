package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class OrangeHRMPage extends BaseClass {
	
	public String empid;

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginbutton;

	@FindBy(xpath = "//img[@alt='client brand banner']")
	private WebElement oragehrmlogo;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimLink;

	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmployee;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "middleName")
	private WebElement middleName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	private WebElement empId;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement save;

	@FindBy(xpath = "//label[text()='Nationality']/parent::div/following-sibling::div/child::div[@class='oxd-select-wrapper']")
	private WebElement countrydropdown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']/child::span"))
	private List<WebElement> countryList;

	@FindBys(@FindBy(xpath = "//input[@type='radio']"))
	private List<WebElement> genderList;

	@FindBy(xpath = "//p[text()=' * Required']/parent::div/child::button")
	private WebElement savebutton;

	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement employeeList;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	private WebElement empid1;

	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement search;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	private WebElement deleteicon;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	private WebElement confirmdelete;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement profileicon;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	

	public OrangeHRMPage() {
		PageFactory.initElements(driver, this);

	}

	public void enterUsernameAndPassword(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
	}

	public void userClickOnLoginButton() {
		loginbutton.click();

	}

	public String userValidateHomepageUrl() {
		String actualUrl = driver.getCurrentUrl();
		return actualUrl;
	}

	public String userValidateHomepageTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

	public boolean userValidateLogo() {
		Boolean logostatus = oragehrmlogo.isDisplayed();
		return logostatus;
	}

	public void clickOnPimLink() throws InterruptedException {
		Thread.sleep(3000);
		pimLink.click();
	}

	public void userClickOnAddEmployee() throws InterruptedException {
		Thread.sleep(3000);
		addEmployee.click();

	}

	public void EnterDetailsAndCaptureEmpID(String fname, String mname, String lname) {
		firstName.sendKeys(fname);
		middleName.sendKeys(mname);
		lastName.sendKeys(lname);
		empid = empId.getAttribute("value");
		System.out.println(empid);


	}

	public void clickOnSaveButton() throws InterruptedException {
		Thread.sleep(5000);
		save.click();

	}

	public void SelectCountryandGender(String Country, String gender) throws InterruptedException {

		Thread.sleep(5000);
		countrydropdown.click();
		//Actions act=new Actions(driver);
		//act.click(countrydropdown);
		Thread.sleep(3000);
		for (WebElement clist : countryList) {
			String actualResult = clist.getText();
			if (actualResult.equalsIgnoreCase(Country)) {
				clist.click();
				break;
			}

		}

		Thread.sleep(5000);
		for (WebElement glist : genderList) {
			String result = glist.getText();
			if (result.equalsIgnoreCase(gender)) {
				glist.click();
				break;
			}

		}
		
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		Thread.sleep(2000);
		savebutton.click();

	}

	public void clickOnEmpList() {

		employeeList.click();

	}

	public void enterEmpId() throws InterruptedException {
		Thread.sleep(5000);
		empid1.sendKeys(empid);

	}

	public void clickOnSearch() {
		search.click();

	}

	public void deleteEmployee() throws InterruptedException {
		Thread.sleep(5000);
		deleteicon.click();
		confirmdelete.click();

	}

	public void clickOnProfileIcon() {
		profileicon.click();

	}

	public void clickOnLogout() {
		logout.click();

	}

	public boolean LoginPage() {
		String loginURL = driver.getCurrentUrl();
		boolean result = loginURL.contains("login");
		return result;

	}

}
