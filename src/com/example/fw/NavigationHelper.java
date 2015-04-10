package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void openMainPage() {
		if (!onMainPage()) {
			click(By.linkText("home"));	
		}		
	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;		
	}

	public void gotoGroupPage() {
		if (!onGroupPage()) {
			click(By.linkText("groups"));	
		}			
	}

	private boolean onGroupPage() {			
		if (driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size() > 0) {
			return true;			
		} else {
			return false;
		}		
	}

	public void gotoHomePage() {
		click(By.linkText("home page"));		
	}

}
