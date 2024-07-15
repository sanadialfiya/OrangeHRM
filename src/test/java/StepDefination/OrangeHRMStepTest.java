package StepDefination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import BaseLayer.BaseClass;
import PageLayer.OrangeHRMPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMStepTest extends BaseClass {

	private static OrangeHRMPage orange;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		BaseClass.initialization();

	}

	@When("And user enter password as {string} and username as {string}")
	public void and_user_enter_password_as_and_username_as(String uname, String pass) {
		orange = new OrangeHRMPage();
		orange.enterUsernameAndPassword(uname, pass);

	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
		orange.userClickOnLoginButton();

	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("user is on home page");

	}

	@Then("user validate homepageURL")
	public void user_validate_homepage_url() {

		String url = orange.userValidateHomepageUrl();
		assertEquals(url.contains("orange"), true);
	}

	@Then("user validate HomepageTitle")
	public void user_validate_homepage_title() {
		String title = orange.userValidateHomepageTitle();
		assertEquals(title.equalsIgnoreCase("OrangeHRM"), true);

	}

	@Then("user validate logo")
	public void user_validate_logo() {
		boolean logostatus = orange.userValidateLogo();
		assertEquals(logostatus, true);

	}

	@Given("user is on pim page when click on PIM link")
	public void user_is_on_pim_page_when_click_on_pim_link() throws InterruptedException {

		orange.clickOnPimLink();
	}

	@Then("user click on add employee")
	public void user_click_on_add_employee() throws InterruptedException {
		orange.userClickOnAddEmployee();

	}

	@Then("Enter {string},{string},{string} and capture the employee id")
	public void enter_and_capture_the_employee_id(String firstname, String middlename, String lastname) {
		orange.EnterDetailsAndCaptureEmpID(firstname, middlename, lastname);

	}

	@Then("click on save button")
	public void click_on_save_button() throws InterruptedException {
		orange.clickOnSaveButton();

	}
	@Then("enter {string} and select {string}")
	public void enter_and_select(String Country, String gender) throws InterruptedException {
		orange.SelectCountryandGender(Country, gender);
	    
	}


@Then("click on the save button")
public void click_on_the_save_button() throws InterruptedException {
	orange.clickSaveButton();
    
}

	

	@Then("click on employee list button")
	public void click_on_employee_list_button() {
		new OrangeHRMPage().clickOnEmpList();

	}

	@Then("enter the employee id")
	public void enter_the_employee_id() throws InterruptedException {
		new OrangeHRMPage().enterEmpId();

	}

	@Then("click on search button")
	public void click_on_search_button() {
		new OrangeHRMPage().clickOnSearch();

	}

	@Then("delete employee and confirm delete")
	public void delete_employee_and_confirm_delete() throws InterruptedException {
		new OrangeHRMPage().deleteEmployee();

	}

	@When("user click on profile icon")
	public void user_click_on_profile_icon() {
		new OrangeHRMPage().clickOnProfileIcon();
	}

	@When("click on logout")
	public void click_on_logout() {
		new OrangeHRMPage().clickOnLogout();

	}

	@Then("user is on loginPage again")
	public void user_is_on_login_page_again() {
		boolean result = new OrangeHRMPage().LoginPage();
		assertEquals(result, true);
		driver.quit();

	}

}
