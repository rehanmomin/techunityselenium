package com.techunity.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.techunity.qa.util.PageFactoryInit;
import com.techunity.qa.util.TestUtil;

public class LogoutPage extends PageFactoryInit {
	
	@FindBy (xpath = "//a[contains(text(),\"Customer: custuser01\")]")
	WebElement customerName;
	
	@FindBy (xpath = "//a[@title = \"Logout\"]")
	WebElement logout;
	
	public LogoutPage() {
		super();
	}
	
	public void logout() {
		TestUtil.verifyAndClick(customerName);
		TestUtil.verifyAndClick(logout);
		
	}
}
