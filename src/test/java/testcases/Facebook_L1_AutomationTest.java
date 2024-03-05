

package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookPage;
import pages.StartupPage;
import testBase.AppTestBase;

public class Facebook_L1_AutomationTest extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FaceBookPage FaceBookPageInstance;
	
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="Validate the login Page")
	public void validateFacebookLoginPage() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validateTheLoginPage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "LoginPage_Title");
		softAssert.assertEquals(FaceBookPageInstance.validateTheLoginPage(), expectedData.get("loginpageTitle"), 
				"page title is not matching please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="Validate username field is present in the login Page")
	public void validatePresenceOfOtherFieldsInLoginPage() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validatePresenceOfAllFieldInTheLoginPage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "username_field");
		softAssert.assertEquals(FaceBookPageInstance.validatePresenceOfAllFieldInTheLoginPage(), expectedData.get("username_field_Title"), 
				"user name is not matching please check manually");
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Validate incorrect username message")
	public void Validate_incorrectUsername() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_Incorrect_username() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_Username");
		softAssert.assertEquals(FaceBookPageInstance.Validate_Incorrect_username(), expectedData.get("incorrect_username_meassge"), 
				"username is not matching please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Validate incorrect password message")
	public void Validate_incorrect_password() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_Incorrect_Password() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_password");
		softAssert.assertEquals(FaceBookPageInstance.Validate_Incorrect_Password(), expectedData.get("incorrect_password_meassge"), 
				"password is not matching please check manually");
	}
	
	
	@Test(priority = 5, groups = {"sanity"}, description="Provide valid username and password")
	public void Login() throws Exception {
	
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method username_password() has to be implemented by the implementor
		String page= FaceBookPageInstance.username_password();
		softAssert.assertNotNull(page);

	}
	

	@Test(priority = 6, groups = {"sanity"}, description="Validate that the login button is present and clickable")
	public void login_button_is_Clickable() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method loginbutton_is_present_clickable() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Login_button");
		softAssert.assertEquals(FaceBookPageInstance.loginbutton_is_present_clickable(), expectedData.get("Login_button_meassge"), 
				"login button is not present please check manually");
		
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Validate title of the login page after successfully loggedin")
	public void Validate_title_of_the_login_page() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method titleoftheloginpage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "login_page_title");
		softAssert.assertEquals(FaceBookPageInstance.titleoftheloginpage(), expectedData.get("login_page_title_meassge"), 
				"page title is not matching please check manually");
		
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="verify Forgot Password? link redirects to the password recovery page")
	public void forgot_password() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Click_on_forgot_password() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Forgot_Password");
		softAssert.assertEquals(FaceBookPageInstance.Click_on_forgot_password(), expectedData.get("Forgot_Password_title"), 
				"forgot password page title is not matching please check manually");
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Verify that clicking on the Create New Account button")
	public void Create_New_Account() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Click_on_Create_new_account() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.Click_on_Create_new_account();
		softAssert.assertNotNull(page);

	}
	@Test(priority = 10, groups = {"sanity"}, description="Verify that user navigates to the signup page")
	public void CreateNewAccount() throws Exception {
		
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_the_signUp_page() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Sign_up_page");
		softAssert.assertEquals(FaceBookPageInstance.navigate_to_the_signUp_page(), expectedData.get("Sign_up_page_title"), 
				"sign up page title is not matching please check manually");
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="Enter values in the First name and Surname")
	public void Enter_data_in_First_name_Surname() throws Exception {
			
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method enter_firstName_surname() has to be implemented by the implementor
		String page=FaceBookPageInstance.enter_firstName_surname();
		softAssert.assertNotNull(page);

	}
	
	@Test(priority = 12, groups = {"sanity"}, description="Enter values in the Mobile number field")
	public void Enter_data_in_Mobile_number_password() throws Exception {
			
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method enter_MobileNumber() has to be implemented by the implementor
		String page=FaceBookPageInstance.enter_MobileNumber();
		softAssert.assertNotNull(page);
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="Select different dates from the Date Of Birth fields")
	public void Date_Of_Birth_fields() throws Exception {
			
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method select_different_DOB_fields() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.select_different_DOB_fields();
		softAssert.assertNotNull(page);
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="Verify selected DOB values should be captured accurately")
	public void DOB_values_captured_accurately() throws Exception {
			
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method verify_captured_DOB_values() has to be implemented by the implementor
		String page=FaceBookPageInstance.verify_captured_DOB_values();
		softAssert.assertNotNull(page);

	}
	@Test(priority = 16, groups = {"sanity"}, description="Select each radio button option for gender")
	public void Select_each_radio_button() throws Exception {
			
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method select_radio_buttons() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.select_radio_buttons();
		 softAssert.assertNotNull(page);

	}
	
	@Test(priority = 17, groups = {"sanity"}, description="Validate that male radio button option should be selectable at a time")
	public void select_one_radio_button() throws Exception {
			
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_only_one_radio_button_should_be_selectable() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "male_radio_button");
		softAssert.assertEquals(FaceBookPageInstance.Validate_only_one_radio_button_should_be_selectable(), expectedData.get("male_radio_button_title"), 
				"male radio button is not selected please check manually");
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="Verify that clicking on the Terms link redirects to the Facebook Terms of Service page")
	public void clicking_on_the_Terms() throws Exception {
			
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_Terms_page() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Terms_link");
		softAssert.assertEquals(FaceBookPageInstance.navigate_to_Terms_page(), expectedData.get("Terms_link_title"), 
				"page title is not matching please check manually");
	}
	
	@Test(priority = 19, groups = {"sanity"}, description="Ensure that clicking on the privacy Policy link redirects to the Facebook Data Policy page")
	public void clicking_on_the_Data_Policy_link() throws Exception {	
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_Data_Policy() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Data_Policy_link");
		softAssert.assertEquals(FaceBookPageInstance.navigate_to_Data_Policy(), expectedData.get("Data_Policy_link_title"), 
				" privacy policy page title is not matching please check manually");
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="Click on the sign up button,leave the new password as empty")
	public void click_on_sign_up() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clicking_on_sign_up() has to be implemented by the implementor
		 FaceBookPage page=FaceBookPageInstance.clicking_on_sign_up();
		 softAssert.assertNotNull(page);

	}
	
	@Test(priority = 21, groups = {"sanity"}, description="Verify that error messages for incomplete field displayed as appropriate")
	public void verify_error_message() throws Exception {	
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validate_the_error_message() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "error_message");
		softAssert.assertEquals(FaceBookPageInstance.validate_the_error_message(), expectedData.get("verify_error_message"), 
				" error message is not matching please check manually");
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}
