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
	 
	 
	 
	 

	public FaceBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize Page Factory
		// TODO Auto-generated constructor stub
	}
	
	
	/**
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
	
	/**
	 * about this method facebookLoginForm() 
	 * @param : Map<String, String> expectedData
	 * @description : it is fill the forms and click on  login button  ,
	 * @return : null
	 * @author : Yaksha
	 */
	public FaceBookPage facebookLoginForm(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(emailAddsPhoneNumberTextbox,expectedData.get("emailAddsPhoneNumber"));	
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));
			commonEvents.click(loginButton);
			Thread.sleep(5000);
			commonEvents.click(profileIconImage);
			
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);
	}
	
	/**
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
	
	/**
	 * about this method validateErrorMessage() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessage() throws Exception {
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
	 * about this method enterEmailIdOrPhoneNumber() 
	 * @param : Map<String, String> expectedData
	 * @description : it is sending the email or phone no as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public void enterEmailIdOrPhoneNumber(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(emailTextField,expectedData.get("emailAddsPhoneNumber"));	
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
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
	 * @param : null
	 * @description : it is sending the password as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public void enterPassword(Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.clear(emailAddsPhoneNumberTextbox);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));	
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * about this method goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() 
	 * @param : null
	 * @description : here checking whether the element is present or not 
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
	
	/**
	 * about this method validateNavigateToTheSignUpPage() 
	 * @param : null
	 * @description : click on the createnew account and validate the page title ,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateNavigateToTheSignUpPage() throws Exception {
		try {
			commonEvents.click(createNewAccount);
			commonEvents.waitTillElementLocated(createNewAccount, 60);
			String signUpPageTitle	=  driver.getTitle();
			System.out.println("Title of the Login Page : " + signUpPageTitle );
			return signUpPageTitle;
			
		}catch(Exception e) {
			throw e;
		}
	}


	/**
	 * about this method enterDataInFirstNameField() 
	 * @param : Map<String, String>
	 * @description : Enter data in the first name text field ,
	 * @return : String
	 * @author : Yaksha
	 */
	public  String enterDataInFirstNameField( Map<String, String> expectedData) throws Exception {
		try {
			commonEvents.sendKeys(firstNameTextField,expectedData.get("FirstName"));
			String firstNameTextFieldString=commonEvents.getText(firstNameTextField);
			System.out.println(firstNameTextFieldString);
			return firstNameTextFieldString;
		}catch(Exception e) {
			throw e;
		}
		
	}
	/**
	 * about this method verifyPresenceOfAllFieldsPresentInTheSignUpPage() 
	 * @param : null
	 * @description : verify all fields are present in the signup page ,
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
	
	/**
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
				commonEvents.sendKeys(mobileNumberAndPassword,expectedData.get("mobileNumberandpassword"));
				commonEvents.sendKeys(newPassword,expectedData.get("newPassword"));

			}catch(Exception e) {
				throw e;
			}
		}
	

}
