package com.google.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * The class has all common methods which are used in all different pages
 * @author aida
 *
 */
public class DriverUtil {

	private WebDriver driver;

	public DriverUtil(WebDriver newDriver) {

		this.driver = newDriver;

	}

	public void maximizeBrowser() throws Exception {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw e;
		}

	}

	public void goToUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {

			throw e;
		}
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getPageTitle() throws Exception {
		String title = driver.getTitle();
		return title;

	}

	/**
	 * the method gets the list of all search links texts in result page
	 * 
	 * @param locator element
	 * @throws Exception
	 */
	public void getPageResultSections(By locator) throws Exception {

		List<WebElement> sections = driver.findElements(locator);
		for (WebElement section : sections) {
			System.out.println("page result sectons : " + " " + section.getText());

		}

	}

}
