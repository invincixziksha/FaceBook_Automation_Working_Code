package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage extends StartupPage {
	//please write all the locators for facebook page only 

	By loginButton = By.xpath("//button[@name='login']"); 
	By EmailAddsPhoneNumberTextbox = By.xpath("//input[@placeholder='Email address or phone number']"); 
	By passwordTextbox = By.xpath("//input[@placeholder='Password']"); 
	By profileIconImage = By.xpath("(//div//div//span)[14]"); 
	By logoutButton = By.xpath("//span[contains(text (), 'Log out')]"); 
	By forgettenPasswordLink = By.xpath("//a[.='Forgotten password?']"); 
	By createNewAccountLink = By.xpath("//a[contains(text() , 'Create new account')]"); 
	By emailTextField = By.id("email"); 
	By errorMessage1 = By.xpath("//div[@id='email_container']//div[2]"); 
	By errorMessage2 = By.xpath("//div[@id='email_container']//div[2]/a"); 
	By errorMessage3 = By.xpath("//div[@class='_9ay7']"); 
	By errorMessage4 = By.xpath("(//div[@class='_9ay7']//div//div)[1]"); 
	By createNewAccount = By.xpath("//a[contains(text() , 'Create new account')]"); 
	
	By CreateNewAccount = By.xpath("//a[contains(text(),'Create new account')]"); 
	By SignUpButton = By.xpath("//button[@name=\"websubmit\"]"); 
	By NameFieldErorMessage = By.xpath("//div[@id='js_134']"); 
	By FirstNameTextField = By.xpath("//input[@name=\"firstname\"]"); 
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
			commonEvents.sendKeys(EmailAddsPhoneNumberTextbox,expectedData.get("emailAddsPhoneNumber"));	
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
			if(commonEvents.isDisplayed(EmailAddsPhoneNumberTextbox)&&
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
			String ErrorMessageValue =  commonEvents.getText(errorMessage1) + commonEvents.getText(errorMessage2);
			return ErrorMessageValue ;
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
//			String ErrorMessageValue =  commonEvents.getText(errorMessage3) + commonEvents.getText(errorMessage4);
			String ErrorMessageValue =  commonEvents.getText(errorMessage3);
			System.out.println("Error Message : " + ErrorMessageValue);
			return ErrorMessageValue ;
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
			commonEvents.clear(EmailAddsPhoneNumberTextbox);
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
			commonEvents.click(CreateNewAccount);
			commonEvents.waitTillElementLocated(CreateNewAccount, 60);
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
			commonEvents.sendKeys(FirstNameTextField,expectedData.get("FirstName"));
			String FirstNameTextFieldString=commonEvents.getText(FirstNameTextField);
			System.out.println(FirstNameTextFieldString);
			return FirstNameTextFieldString;
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
			if(commonEvents.isDisplayed(FirstNameTextField)&&
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
	 * @return : String
	 * @author : Yaksha
	 *
	 */
		public  String enterDataInSignUpPage( Map<String, String> expectedData) throws Exception {
			try {
				commonEvents.sendKeys(surNameTextField,expectedData.get("surname"));
				commonEvents.sendKeys(mobileNumberAndPassword,expectedData.get("mobileNumberandpassword"));
				commonEvents.sendKeys(newPassword,expectedData.get("newPassword"));

				return "";
			}catch(Exception e) {
				throw e;
			}
		}
	

}
