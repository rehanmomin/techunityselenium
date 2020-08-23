package com.techunity.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techunity.qa.base.TestBase;
import com.techunity.qa.pages.HomePage;
import com.techunity.qa.pages.LoginPage;
import com.techunity.qa.pages.LogoutPage;


public class TechUnityTestFlows extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logoutPage;
	
	public TechUnityTestFlows() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		logoutPage = new LogoutPage();
	}
	
	@Test
	public void VerifyLogin() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logoutPage.logout();
	}
	
	@Test
	public void verifySupportTicket() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage.viewTicketAndProvideReponse("This is Selenium Test");
		logoutPage.logout();
	}
	
	@Test
	public void verifyCurrentRentals() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage.viewCurrentRentals("This is Selenium Test");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


