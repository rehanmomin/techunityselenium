package com.techunity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.techunity.qa.util.PageFactoryInit;
import com.techunity.qa.util.TestUtil;

public class LoginPage extends PageFactoryInit {
	
	@FindBy (id = "uname")
	WebElement username;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (id = "btnlogin")
	WebElement login;
	
	public LoginPage() {
		super();
	}
	
	public void login(String uname, String pwd) {
		
		TestUtil.verifyAndSendKeys(username, uname);
		TestUtil.verifyAndSendKeys(password, pwd);
		TestUtil.verifyAndClick(login);
				
	
	}
	
	
}
