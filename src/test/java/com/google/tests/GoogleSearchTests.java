package com.google.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.base.BaseTest;
import com.google.pages.GooglePage;
import com.google.pages.ResultPage;

/**
 * The class has tests required for searching on google pages and printing the
 * results
 * 
 * @author aida
 */

public class GoogleSearchTests extends BaseTest {
	@DataProvider
	public Object[][] languages() {
		return new Object[][] { { "en" }, };
	}

	@Test(testName = "Verify Google serach Title and results for first google search result page and printing them in console", dataProvider = "languages")
	public void searchFirstResultPage(String language) throws Exception {

		// initializes the test with English language passed as parameter
		initializeTest(language);
		// load English property file to assert the texts written in property file not
		// in each test individually
		initProperties("en");
		// google page instantiation
		GooglePage google = new GooglePage(driverUtil);

		// search for programming word on google search, searchword comes from property
		// file
		ResultPage result = google.search(getValue("searchWord"));

		// prints the main page title
		System.out.println("Main Page Title : " + "" + driverUtil.getPageTitle());
		// assert the page title to be like the expected one
		Assert.assertTrue(driverUtil.getPageTitle().contains(getValue("resultPageTitle")));
		// print all the page result sections
		driverUtil.getPageResultSections(By.className(result.searchElement));

	}

	@Test(testName = "Verify Google serach Title and results for second google search result page and printing them in console", dataProvider = "languages")
	public void searchSecondResultPage(String language) throws Exception {

		// initializes the test with English language passed as parameter
		initializeTest(language);
		// load English property file to assert the texts written in property file not
		// in each test individually
		initProperties("en");
		// google page instantiation
		GooglePage google = new GooglePage(driverUtil);
		// search for programming word on google search, searchword comes from property
		// file
		ResultPage result = google.search(getValue("searchWord"));
		// go to second page of results
		result.goToNextResultPage();
		// prints the main page title
		System.out.println("Main Page Title : " + "" + driverUtil.getPageTitle());
		// assert the page title to be equal with expected one
		Assert.assertTrue(driverUtil.getPageTitle().contains(getValue("resultPageTitle")));
		// print all the page result sections
		driverUtil.getPageResultSections(By.className(result.searchElement));
	}

}
