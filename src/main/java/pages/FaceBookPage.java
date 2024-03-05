package pages;

import org.openqa.selenium.WebDriver;

public class FaceBookPage extends StartupPage {

	public FaceBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

	public String validateTheLoginPage() 
	{
		
		return null;
	}
	public String validatePresenceOfAllFieldInTheLoginPage() {
		// TODO Auto-generated method stub
		return null;
	}
	public String Validate_Incorrect_username() {
		// TODO Auto-generated method stub
		return null;
	}
	public String Validate_Incorrect_Password() {
		// TODO Auto-generated method stub
		return null;
	}
	public String username_password() {
		// TODO Auto-generated method stub
		return null;
	}
	public String titleoftheloginpage() {
		// TODO Auto-generated method stub
		return null;
	}
	public FaceBookPage loginbutton_is_present_clickable() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);		
	}
	
	public String Click_on_forgot_password() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FaceBookPage Click_on_Create_new_account()
	{
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	public String navigate_to_the_signUp_page() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String enter_firstName_surname() {
		// TODO Auto-generated method stub
		return null;
	}
	public String enter_MobileNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FaceBookPage select_different_DOB_fields() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	
	public FaceBookPage verify_dates_are_selectable() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	
	public String verify_captured_DOB_values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FaceBookPage select_radio_buttons() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	public FaceBookPage Validate_only_one_radio_button_should_be_selectable() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);
	}
	
	public FaceBookPage navigate_to_Terms_page() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	public FaceBookPage navigate_to_Data_Policy() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	
	public FaceBookPage clicking_on_sign_up() {
		try {
			// TODO Auto-generated method stub
		}catch(Exception e) {
			throw e;
		}
		return new FaceBookPage(driver);	
	}
	
	public String validate_the_error_message() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
