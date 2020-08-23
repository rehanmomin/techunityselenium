package com.techunity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.techunity.qa.util.PageFactoryInit;
import com.techunity.qa.util.TestUtil;

public class HomePage extends PageFactoryInit {
	
	//Support Tickets
	
	@FindBy (xpath = "//*[@id=\"Support Tickets \"]")
	WebElement supportTicket;
	
	@FindBy (id = "MainContent_repSelectlist_btnview_0")
	WebElement viewFirstTicket;
	
	@FindBy (id = "MainContent_txtResponse")
	WebElement txtResponse;
	
	@FindBy (id = "MainContent_btnReply")
	WebElement submit;
	
	//current Rentals
	@FindBy (xpath = "//*[@id=\"Span1\"]")
	WebElement currentRentals;
	
	@FindBy (id = "MainContent_btnnewrental")
	WebElement newRequest;
	
	@FindBy (id = "MainContent_txtDescription")
	WebElement txtDescription;
	
	@FindBy (id = "MainContent_btnSendticket")
	WebElement sendRequest;
	
	public HomePage() {
		super();
	}
	
	public void viewTicketAndProvideReponse(String response) {
		
		TestUtil.verifyAndClick(supportTicket);
		TestUtil.verifyAndClick(viewFirstTicket);
		TestUtil.verifyAndSendKeys(txtResponse, response);
		TestUtil.verifyAndClick(submit);				
	
	}
	
	public void viewCurrentRentals(String response) {
		
		TestUtil.verifyAndClick(currentRentals);
		TestUtil.verifyAndClick(newRequest);
		TestUtil.verifyAndSendKeys(txtDescription, response);
		TestUtil.verifyAndClick(sendRequest);				
	
	}
	
	
}
