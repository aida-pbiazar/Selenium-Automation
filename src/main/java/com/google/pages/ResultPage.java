package com.google.pages;

import org.openqa.selenium.By;

import com.google.utils.DriverUtil;
/**
 * The class constructs result page elements needed for tests
 * @author aida
 */
public class ResultPage {

	private DriverUtil driverUtil;
	public String searchElement = "LC20lb";

	public ResultPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	public ResultPageTwo goToNextResultPage() throws Exception {

		driverUtil.getElement(By.cssSelector("#pnnext > span:nth-child(2)")).click();

		return new ResultPageTwo(driverUtil);

	}

	}
	
	
