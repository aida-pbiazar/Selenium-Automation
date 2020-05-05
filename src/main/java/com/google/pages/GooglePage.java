package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.google.utils.DriverUtil;

/**
 * The class constructs google page elements needed for tests
 * @author aida
 *
 */
public class GooglePage {
	private DriverUtil driverUtil;

	public GooglePage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	/**
	 * the method searches for a word in google box and press enter
	 * 
	 * @param search
	 * @return ResultPage
	 * @throws Exception
	 */
	public ResultPage search(String search) throws Exception {

		getSearchInput().sendKeys(search);
		getSearchInput().sendKeys(Keys.ENTER);

		return new ResultPage(driverUtil);
	}

	public WebElement getSearchInput() throws Exception {
		return driverUtil.getElement(By.name("q"));

	}

}

