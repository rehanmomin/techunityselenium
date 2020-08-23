package com.techunity.qa.util;

import org.openqa.selenium.support.PageFactory;

import com.techunity.qa.base.TestBase;

public class PageFactoryInit extends TestBase {

	public PageFactoryInit() {
		PageFactory.initElements(driver, this);
	}
}
