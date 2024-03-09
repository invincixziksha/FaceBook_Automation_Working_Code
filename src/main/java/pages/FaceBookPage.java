package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage extends StartupPage {
	//please write all the locators for facebook page only 

	By loginButton = By.xpath("//button[@name='login']"); 
	By emailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By profileIconImage = By.xpath("(//div//div//span)[14]"); 
	By logoutButton = By.xpath("//span[contains(text (), 'Log out')]"); 
	By forgettenPasswordLink = By.xpath("//a[.='Forgotten password?']"); 
	By createNewAccountLink = By.xpath("//a[contains(text() , 'Create new account')]"); 
	By emailTextField = By.id("email"); 
	By errorMessageWithoutCredential = By.xpath("//div[@id='email_container']//div[2]"); 
	By errorMessageWithoutCredentialForgetPassword = By.xpath("//div[@id='email_container']//div[2]/a"); 
	By withoutPasswordErrorMessage = By.xpath("//div[contains(@class, 'clearfix') and contains(@class, 'mg')]//div[2]");

	By createNewAccount = By.xpath("//a[contains(text(),'Create new account')]"); 
	By signUpButton = By.xpath("//button[@name=\"websubmit\"]"); 
	By nameFieldErorMessage = By.xpath("//div[@id='js_134']"); 
	By firstNameTextField = By.xpath("//input[@name=\"firstname\"]"); 
	By surNameTextField = By.xpath("//input[@name=\"lastname\"]"); 
	By mobileNumberAndPassword = By.xpath("//input[@name=\"reg_email__\"]"); 
	By newPassword = By.xpath("(//input[@type=\"password\"])[2]"); 
	By selectDateFromDateDropdown = By.xpath("//select[@name='birthday_day']"); 
	By selectBirthdayMonth = By.xpath("//select[@name='birthday_month']");
	By selectBirthDayYear = By.xpath("//select[@name='birthday_year']");
	By customRadioButton = By.xpath("//label[contains(text() , 'Custom')]");
	By selectYourPronounDropdown = By.xpath("//select[@name='preferred_pronoun']");
	By genderOptionalTextBox = By.xpath("//input[@name='custom_gender']");
	By selectFemaleRadioButton = By.xpath("//label[contains(text() , 'Female')]");
	By selectMaleRadioButton = By.xpath("//label[contains(text() , 'Male')]");
	By closeSignupPageImage = By.xpath("//img[contains(@src, '.png')]");





	public FaceBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize Page Factory
		// TODO Auto-generated constructor stub
	}


	/** @test1
	 * about this method validateFacebookTitleOfLoginPage() 
	 * @param : null
	 * @description : it is getting the page title and return the same,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateFacebookTitleOfLoginPage() throws Exception {
		try {

			String currentPageTitle	=  driver.getTitle();
			System.out.println("Title of the Login Page : " + currentPageTitle );
			return currentPageTitle;
		}catch(Exception e) {
			throw e;
		}
	}

	/**@test2
	 * about this method verifyPresenceOfALlFields() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfALlFields() throws Exception {
		try {
			if(commonEvents.isDisplayed(emailAddsPhoneNumberTextbox)&&
					commonEvents.isDisplayed(passwordTextbox)&&
					commonEvents.isDisplayed(forgettenPasswordLink)&&
					commonEvents.isDisplayed(createNewAccountLink)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test3
	 * about this method validateErrorMessageWithoutProvideAnyCredentials() 
	 * @param : null
	 * @description : it is getting the error message if login button clicked without passing email and password
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideAnyCredentials() throws Exception {
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(emailTextField, 60);
			String errorMessageWithoutCredentials =  commonEvents.getText(errorMessageWithoutCredential) + commonEvents.getText(errorMessageWithoutCredentialForgetPassword);
			return errorMessageWithoutCredentials ;
		}catch(Exception e) {
			throw e;
		}
	}

	/**
	 * about this method enterEmailIdOrPhoneNumberInLoginPage() 
	 * @param : Map<String, String> expectedData
	 * @description : enter EmailIdOrPhoneNumber in the EmailIdOrPhoneNumber text field of the login page as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public void enterEmailIdOrPhoneNumberInLoginPage(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(emailTextField,expectedData.get("emailAddsPhoneNumber"));	
		}catch(Exception e) {
			throw e;
		}
	}

	/**@test4
	 * about this method validateErrorMessageWithoutProvidePassword() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvidePassword(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(passwordTextbox, 60);
			String errorMessageWithoutPassword =  commonEvents.getText(withoutPasswordErrorMessage);
			System.out.println("Error Message : " + errorMessageWithoutPassword);
			return errorMessageWithoutPassword ;
		}catch(Exception e) {
			throw e;
		}
	}

	/**
	 * about this method enterPassword() 
	 * @param : Map<String, String> expectedData
	 * @description : enter password in the password text field of the login page as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public void enterPasswordInLoginPage(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.clear(emailAddsPhoneNumberTextbox);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));	
		}catch(Exception e) {
			throw e;
		}
	}

	/**@test5
	 * about this method validateErrorMessageWithoutProvideEmailOrPhoneNumber() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideEmailOrPhoneNumber() throws Exception {
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(emailTextField, 60);
			String errorMessageWithoutCredentials =  commonEvents.getText(errorMessageWithoutCredential) + commonEvents.getText(errorMessageWithoutCredentialForgetPassword);
			return errorMessageWithoutCredentials ;
		}catch(Exception e) {
			throw e;
		}
	}

	/**@test6
	 * about this method goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() 
	 * @param : null
	 * @description : here go back to the login page and verify whether the NewAccountButton element is present or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() throws Exception {
		try {
			driver.navigate().back();
			driver.get("https://www.facebook.com/");
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(createNewAccount, 60);
			if(commonEvents.isDisplayed(createNewAccount)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test7
	 * about this method validateNavigateToTheSignUpPage() 
	 * @param : null
	 * @description : click on the createnew account and validate the sign up page title ,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateNavigateToTheSignUpPage() throws Exception {
		try {
			commonEvents.click(createNewAccount);
			commonEvents.waitTillElementLocated(createNewAccount, 60);
			String signUpPageTitle	=  driver.getTitle();
			System.out.println("Title of the Signup Page : " + signUpPageTitle );
			return signUpPageTitle;

		}catch(Exception e) {
			throw e;
		}
	}

	/**@test8
	 * about this method verifyPresenceOfAllFieldsPresentInTheSignUpPage() 
	 * @param : null
	 * @description : verify all fields are present in the signup page or not ,
	 * @return : boolean
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfAllFieldsPresentInTheSignUpPage() throws Exception {
		try {
			if(commonEvents.isDisplayed(firstNameTextField)&&
					commonEvents.isDisplayed(surNameTextField)&&
					commonEvents.isDisplayed(mobileNumberAndPassword)&&
					commonEvents.isDisplayed(newPassword)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test9
	 * about this method enterDataInFirstNameFieldSignupPage() 
	 * @param : Map<String, String>
	 * @description : Enter data in the first name text field of the Signup page,
	 * @return : String
	 * @author : Yaksha
	 */
	public  String enterDataInFirstNameFieldSignupPage( Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(firstNameTextField,expectedData.get("FirstName"));
			String firstNameTextFieldString=commonEvents.getText(firstNameTextField);
			System.out.println(firstNameTextFieldString);
			return firstNameTextFieldString;
		}catch(Exception e) {
			throw e;
		}

	}

	/**@test10
	 * about this method enterDataInSignUpPage() 
	 * @param : Map<String, String>
	 * @description : enter data in the  SignUpPage page,
	 * @return : null
	 * @author : Yaksha
	 *
	 */
	public  void enterDataInSignUpPage( Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(surNameTextField,expectedData.get("surname"));
			commonEvents.sendKeys(mobileNumberAndPassword,expectedData.get("emailOrMobileNumber"));
			commonEvents.sendKeys(newPassword,expectedData.get("newPassword"));
		}catch(Exception e) {
			throw e;
		}
	}

	/**@test11
	 * about this method selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any date from date dropdown and verify Date Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() throws Exception {
		commonEvents.selectByValue(selectDateFromDateDropdown, "25");
		try {
			if(commonEvents.isDisplayed(selectDateFromDateDropdown)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test12
	 * about this method selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any month from month dropdown and verify month Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() throws Exception {
		commonEvents.selectByValue(selectBirthdayMonth, "Jun");
		try {
			if(commonEvents.isDisplayed(selectBirthdayMonth)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test13
	 * about this method selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any Year from Year dropdown and verify Year Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() throws Exception {
		commonEvents.selectByValue(selectBirthDayYear, "1996");
		try {
			if(commonEvents.isDisplayed(selectBirthDayYear)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test14
	 * about this method selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "custom" radio button and verify "custom" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() throws Exception {
		commonEvents.click(customRadioButton);
		try {
			if(commonEvents.isDisplayed(customRadioButton)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test15
	 * about this method selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any option from "SelectYourPronoun" dropdown and verify "SelectYourPronoun" is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() throws Exception {
		commonEvents.selectByVisibleText(selectYourPronounDropdown, "He: \"Wish him a happy birthday!\"");
		try {
			if(commonEvents.isDisplayed(selectYourPronounDropdown)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test16
	 * about this method enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot() 
	 * @param : null
	 * @description : send the value in In Gender Optional TextField and verify Gender Optional TextField is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		commonEvents.sendKeys(genderOptionalTextBox,expectedData.get("GenderOptionalValue"));
		try {
			if(commonEvents.isDisplayed(genderOptionalTextBox)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test17
	 * about this method selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Female" radio button and verify "Female" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() throws Exception {
		commonEvents.click(selectFemaleRadioButton);
		try {
			if(commonEvents.isDisplayed(selectFemaleRadioButton)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test18
	 * about this method selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Male" radio button and verify "male" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() throws Exception {
		commonEvents.click(selectMaleRadioButton);
		try {
			if(commonEvents.isDisplayed(selectMaleRadioButton)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test19
	 * about this method verifyAllprsenceOfFieldAfterCloseTheSignupPage() 
	 * @param : null
	 * @description : close the sign up page and verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyAllprsenceOfFieldAfterCloseTheSignupPage() throws Exception {
		commonEvents.click(closeSignupPageImage);
		try {
			if(commonEvents.isDisplayed(emailAddsPhoneNumberTextbox)&&
					commonEvents.isDisplayed(passwordTextbox)&&
					commonEvents.isDisplayed(forgettenPasswordLink)&&
					commonEvents.isDisplayed(createNewAccountLink)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}

	/**@test20
	 * about this method enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot() 
	 * @param : Map<String, String> expectedData (getting the data from the expected Json file
	 * @description : enter the username and password in the corresponding Text filed and verify login button is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		commonEvents.sendKeys(emailAddsPhoneNumberTextbox,expectedData.get("Username"));
		commonEvents.sendKeys(passwordTextbox,expectedData.get("Password"));
		try {
			if(commonEvents.isDisplayed(loginButton)) {
				return true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return false;
	}


}
