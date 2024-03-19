package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Facebook_L1_Pages extends StartupPage {
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
	By errorMessageWithoutCredential1 = By.xpath("//div[.='Invalid username or password']"); 
	By errorMessageWithoutCredentialForgetPassword = By.xpath("//div[@id='email_container']//div[2]/a"); 
	By withoutPasswordErrorMessage = By.xpath("//div[contains(@class, 'clearfix') and contains(@class, 'mg')]//div[2]");
	By withoutPasswordErrorMessage1 = By.xpath("//div[.='Invalid username or password']");


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





	public Facebook_L1_Pages(WebDriver driver) {
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
		String currentPageTitle="";
		try {
			currentPageTitle= commonEvents.getTitle();
			System.out.println("Title of the Login Page : " + currentPageTitle );
		}catch(Exception e) {
			throw e;
		}
		return currentPageTitle;

	}

	/**@test2
	 * about this method verifyPresenceOfALlFields() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfALlFields() throws Exception {
		Boolean createNewAccountLinkIsDisplayed=false;
		try {
			if(commonEvents.isDisplayed(emailAddsPhoneNumberTextbox)&&
					commonEvents.isDisplayed(passwordTextbox)&&
					commonEvents.isDisplayed(forgettenPasswordLink)&&
					commonEvents.isDisplayed(createNewAccountLink)) {
				createNewAccountLinkIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return createNewAccountLinkIsDisplayed;
	}

	/**@test3
	 * about this method validateErrorMessageWithoutProvideAnyCredentials() 
	 * @param : null
	 * @description : it is getting the error message if login button clicked without passing email and password
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideAnyCredentials() throws Exception {
		String errorMessageWithoutCredentials="";
		String errorMessage="";
		commonEvents.click(loginButton);
		commonEvents.waitTillElementLocated(emailTextField, 60);

		try {
			if(commonEvents.isDisplayed(errorMessageWithoutCredential))
			{
				errorMessageWithoutCredentials =  commonEvents.getText(errorMessageWithoutCredential);
				System.out.println("Error message is :" +errorMessageWithoutCredentials);
				return errorMessageWithoutCredentials;
			}
			else 
			{
				errorMessage=commonEvents.getText(errorMessageWithoutCredential1);
				System.out.println("Error message is :" +errorMessage);
				return errorMessage;
			}
			
		}catch(Exception e) {
			System.out.println("No element found");
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
	public boolean enterEmailIdOrPhoneNumberInLoginPage(Map<String, String> expectedData) throws Exception {
		Boolean emailTextFieldIsDisplayed=false;
		try {
			if(commonEvents.isDisplayed(emailTextField))
			{
			commonEvents.sendKeys(emailTextField,expectedData.get("emailAddsPhoneNumber"));
			emailTextFieldIsDisplayed= true;
			}
		}catch(Exception e) {
			throw e;
		}
		return emailTextFieldIsDisplayed;
	}

	/**@test4
	 * about this method validateErrorMessageWithoutProvidePassword() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvidePassword(Map<String, String> expectedData) throws Exception {
		String errorMessageWithoutPassword="";
		String errorMessage="";
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(passwordTextbox, 60);
			if(commonEvents.isDisplayed(withoutPasswordErrorMessage))
			{
			errorMessageWithoutPassword =  commonEvents.getText(withoutPasswordErrorMessage);
//			System.out.println("Error Message : " + errorMessageWithoutPassword);
			return errorMessageWithoutPassword;
			}
			else
			{
				errorMessage=commonEvents.getText(withoutPasswordErrorMessage1);
				System.out.println("Error message is :" +errorMessage);
				return errorMessage;
			}
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
	public boolean enterPasswordInLoginPage(Map<String, String> expectedData) throws Exception {
		Boolean passwordTextboxisFilled=false;
		try {
			commonEvents.clear(emailAddsPhoneNumberTextbox);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));
			if(commonEvents.getAttribute(passwordTextbox, "value").equals(expectedData.get("password"))) {
				passwordTextboxisFilled = true;
			}

		}catch(Exception e) {
			throw e;
		}
		return passwordTextboxisFilled;
	}

	/**@test5
	 * about this method validateErrorMessageWithoutProvideEmailOrPhoneNumber() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideEmailOrPhoneNumber() throws Exception {
		String errorMessageWithoutCredentials="";
		String errorMessage="";
		try {
			commonEvents.click(loginButton);
			commonEvents.waitTillElementLocated(emailTextField, 60);
			if(commonEvents.isDisplayed(errorMessageWithoutCredential))
			{
				errorMessageWithoutCredentials =  commonEvents.getText(errorMessageWithoutCredential);
				System.out.println("Error message is:"+errorMessageWithoutCredentials);
				return errorMessageWithoutCredentials ;
			}
			else
			{
			errorMessage =  commonEvents.getText(errorMessageWithoutCredential1);
			System.out.println("Error message is:"+errorMessageWithoutCredentials);
			return errorMessage;
			}
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
		Boolean createNewAccountIsDisplayed=false;
		try {
            commonEvents.navigateBack();		
            driver.get("https://www.facebook.com/");
			Thread.sleep(5000);
			commonEvents.waitTillElementLocated(createNewAccount, 60);
			if(commonEvents.isDisplayed(createNewAccount)) {
				createNewAccountIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return createNewAccountIsDisplayed;
	}

	/**@test7
	 * about this method validateNavigateToTheSignUpPage() 
	 * @param : null
	 * @description : click on the createnew account and validate the sign up page title ,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateNavigateToTheSignUpPage() throws Exception {
		String signUpPageTitle="";
		try {
			commonEvents.click(createNewAccount);
			commonEvents.waitTillElementLocated(createNewAccount, 60);
			signUpPageTitle	=  driver.getTitle();
			System.out.println("Title of the Signup Page : " + signUpPageTitle );

		}catch(Exception e) {
			throw e;
		}
		return signUpPageTitle;

	}

	/**@test8
	 * about this method verifyPresenceOfAllFieldsPresentInTheSignUpPage() 
	 * @param : null
	 * @description : verify all fields are present in the signup page or not ,
	 * @return : boolean
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfAllFieldsPresentInTheSignUpPage() throws Exception {
		Boolean newPasswordIsDisplayed=false;
		try {
			if(commonEvents.isDisplayed(firstNameTextField)&&
					commonEvents.isDisplayed(surNameTextField)&&
					commonEvents.isDisplayed(mobileNumberAndPassword)&&
					commonEvents.isDisplayed(newPassword)) {
				newPasswordIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return newPasswordIsDisplayed;
	}

	/**@test9
	 * about this method enterDataInFirstNameFieldSignupPage() 
	 * @param : Map<String, String>
	 * @description : Enter data in the first name text field of the Signup page,
	 * @return : String
	 * @author : Yaksha
	 */
	public  String enterDataInFirstNameFieldSignupPage( Map<String, String> expectedData) throws Exception {
		String firstNameTextFieldString="";
		try {
			commonEvents.sendKeys(firstNameTextField,expectedData.get("FirstName"));
			firstNameTextFieldString=commonEvents.getText(firstNameTextField);
			System.out.println(firstNameTextFieldString);
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextFieldString;
	}

	/**@test10
	 * about this method enterDataInSignUpPage() 
	 * @param : Map<String, String>
	 * @description : enter data in the  SignUpPage page,
	 * @return : null
	 * @author : Yaksha
	 *
	 */
	public  boolean enterDataInSignUpPage( Map<String, String> expectedData) throws Exception {
		Boolean newPasswordIsFilled=false;
		try {
			commonEvents.sendKeys(surNameTextField,expectedData.get("surname"));
			commonEvents.sendKeys(mobileNumberAndPassword,expectedData.get("emailOrMobileNumber"));
			commonEvents.sendKeys(newPassword,expectedData.get("newPassword"));
			if(commonEvents.getAttribute(newPassword, "value").equals(expectedData.get("newPassword"))) {
				newPasswordIsFilled = true;
			}
			
		}catch(Exception e) {
			throw e;
		}
		return newPasswordIsFilled;
	}

	/**@test11
	 * about this method selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any date from date dropdown and verify Date Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() throws Exception {
		Boolean selectDateFromDateDropdownIsDisplayed=false;
		commonEvents.selectByValue(selectDateFromDateDropdown, "25");
		try {
			if(commonEvents.isDisplayed(selectDateFromDateDropdown)) {
				selectDateFromDateDropdownIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectDateFromDateDropdownIsDisplayed;
	}

	/**@test12
	 * about this method selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any month from month dropdown and verify month Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() throws Exception {
		Boolean selectBirthdayMonthIsDisplayed=false;
		commonEvents.selectByValue(selectBirthdayMonth, "Jun");
		try {
			if(commonEvents.isDisplayed(selectBirthdayMonth)) {
				selectBirthdayMonthIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectBirthdayMonthIsDisplayed;
	}

	/**@test13
	 * about this method selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any Year from Year dropdown and verify Year Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() throws Exception {
		Boolean selectBirthDayYearIsDisplayed=false;
		commonEvents.selectByValue(selectBirthDayYear, "1996");
		try {
			if(commonEvents.isDisplayed(selectBirthDayYear)) {
				selectBirthDayYearIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectBirthDayYearIsDisplayed;
	}

	/**@test14
	 * about this method selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "custom" radio button and verify "custom" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() throws Exception {
		Boolean customRadioButtonIsDisplayed=false;
		commonEvents.click(customRadioButton);
		try {
			if(commonEvents.isDisplayed(customRadioButton)) {
				customRadioButtonIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return customRadioButtonIsDisplayed;
	}

	/**@test15
	 * about this method selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any option from "SelectYourPronoun" dropdown and verify "SelectYourPronoun" is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() throws Exception {
		Boolean selectYourPronounDropdownIsDisplayed=false;
		commonEvents.selectByVisibleText(selectYourPronounDropdown, "He: \"Wish him a happy birthday!\"");
		try {
			if(commonEvents.isDisplayed(selectYourPronounDropdown)) {
				selectYourPronounDropdownIsDisplayed= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectYourPronounDropdownIsDisplayed;
	}

	/**@test16
	 * about this method enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot() 
	 * @param : null
	 * @description : send the value in In Gender Optional TextField and verify Gender Optional TextField is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		Boolean genderOptionalTextBoxIsDisplayed=false;
		commonEvents.sendKeys(genderOptionalTextBox,expectedData.get("GenderOptionalValue"));
		try {
			if(commonEvents.isDisplayed(genderOptionalTextBox)) {
				genderOptionalTextBoxIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return genderOptionalTextBoxIsDisplayed;
	}

	/**@test17
	 * about this method selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Female" radio button and verify "Female" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() throws Exception {
		Boolean selectFemaleRadioButtonIsDisplayed=false;
		commonEvents.click(selectFemaleRadioButton);
		try {
			if(commonEvents.isDisplayed(selectFemaleRadioButton)) {
				selectFemaleRadioButtonIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectFemaleRadioButtonIsDisplayed;
	}

	/**@test18
	 * about this method selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Male" radio button and verify "male" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() throws Exception {
		Boolean selectMaleRadioButtonIsDisplayed=false;
		commonEvents.click(selectMaleRadioButton);
		try {
			if(commonEvents.isDisplayed(selectMaleRadioButton)) {
				selectMaleRadioButtonIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return selectMaleRadioButtonIsDisplayed;
	}

	/**@test19
	 * about this method verifyAllprsenceOfFieldAfterCloseTheSignupPage() 
	 * @param : null
	 * @description : close the sign up page and verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyAllprsenceOfFieldAfterCloseTheSignupPage() throws Exception {
		Boolean createNewAccountLinkIsDisplayed=false;
		commonEvents.click(closeSignupPageImage);
		try {
			if(commonEvents.isDisplayed(emailAddsPhoneNumberTextbox)&&
					commonEvents.isDisplayed(passwordTextbox)&&
					commonEvents.isDisplayed(forgettenPasswordLink)&&
					commonEvents.isDisplayed(createNewAccountLink)) {
				createNewAccountLinkIsDisplayed=true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return createNewAccountLinkIsDisplayed;
	}

	/**@test20
	 * about this method enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot() 
	 * @param : Map<String, String> expectedData (getting the data from the expected Json file
	 * @description : enter the username and password in the corresponding Text filed and verify login button is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		Boolean loginButtonIsDisplay=false;
		commonEvents.sendKeys(emailAddsPhoneNumberTextbox,expectedData.get("Username"));
		commonEvents.sendKeys(passwordTextbox,expectedData.get("Password"));
		try {
			if(commonEvents.isDisplayed(loginButton)) {
				loginButtonIsDisplay= true;
			}	
		}catch(Exception e) {
			throw e;	
		}
		return loginButtonIsDisplay;
	}
}
