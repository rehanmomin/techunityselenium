package com.techunity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.techunity.qa.util.PageFactoryInit;
import com.techunity.qa.util.TestUtil;

public class SDLoginPage extends PageFactoryInit {
	
	@FindBy (id = "ctl00_ctl00_RightContent_RightContent_usr")
	WebElement username;
	
	@FindBy (id = "ctl00_ctl00_RightContent_RightContent_pwd")
	WebElement password;
	
	@FindBy (id = "ctl00_ctl00_RightContent_RightContent_login")
	WebElement login;
	
	public SDLoginPage() {
		super();
	}
	
	public void login(String uname, String pwd) {
		
		TestUtil.verifyAndSendKeys(username, uname);
		TestUtil.verifyAndSendKeys(password, pwd);
		TestUtil.verifyAndClick(login);
				
	
	}
	
	
}
