package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AddGroupTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  @Test
  public void testNoEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupGreated();
    GroupData group = new GroupData();
    group.groupname="alisa";
    group.groupheader="voina";
    group.groupfooter="alisavoina";   
	fiilGroupForm(group);
    submitGroupGreation();
    returnToGroupsPage();
  }
  

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupGreated();
    GroupData group = new GroupData("","",""); 
    fiilGroupForm(group);
    submitGroupGreation();
    returnToGroupsPage();
  }

	private void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}
	
	private void submitGroupGreation() {
		driver.findElement(By.name("submit")).click();
	}
	
	private void fiilGroupForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.groupheader);	    
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.groupfooter);
	}
	
	private void initGroupGreated() {
		driver.findElement(By.name("new")).click();
	}
	
	private void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}
	
	private void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

  

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
