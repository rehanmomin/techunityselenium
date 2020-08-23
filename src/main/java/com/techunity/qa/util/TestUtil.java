package com.techunity.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techunity.qa.base.TestBase;

import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 10;
	public static final long IMPLICIT_WAIT = 10;
	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	public static Select select = null;
	public static String mainWindow = null;
	public static String childWindow = null ;

	public static void WaitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void verifyAndSendKeys(WebElement element, String data) {
		WaitForElementToBeVisible(element);
		element.sendKeys(data);
	}

	public static void verifyAndClick(WebElement element) {
		WaitForElementToBeVisible(element);
		element.click();		
	}

	public static void verifyAndSelectFromDD(WebElement element, String data) {
		WaitForElementToBeVisible(element);
		select = new Select(element);
		select.selectByValue(data);
	}
	
	public static void selectDropdownOption(WebElement element, String data) {
		//Click the Option in the list 
		verifyAndClick(element);
		String xpath_expression = "//div[text()='"+data+"']";
		WebElement optionSel = driver.findElement(By.xpath(xpath_expression));
		verifyAndClick(optionSel);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void switchToNewWindow(String title) {

		mainWindow=driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow)){
				if(driver.switchTo().window(childWindow).getTitle().equalsIgnoreCase(title)) {
					driver.switchTo().window(childWindow);
				}

			}
		}

	}

	public static void closeNewWindow(String title) {
		if(driver.switchTo().window(childWindow).getTitle().equalsIgnoreCase(title)) {
			driver.switchTo().window(childWindow).close();
		}


	}

	public static void switchToMainWindow() {
		// This is to switch to the main window
		driver.switchTo().window(mainWindow);
	}

	public static void acceptAlert() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
	}

}
