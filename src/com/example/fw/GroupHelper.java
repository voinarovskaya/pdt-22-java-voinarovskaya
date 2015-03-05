package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));		
	}

	public void submitGroupGreation() {
		click(By.name("submit"));		
	}

	public void initGroupGreated() {
		click(By.name("new"));		
	}

	public void fiilGroupForm(GroupData group) {
		input(By.name("group_name"), group.name);
		input(By.name("group_header"), group.header);
		input(By.name("group_footer"), group.footer);		
	}

	public void initGroupDelete(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//*[@name='selected[]'][" + (index +1) + "]"));
	}

	public void initGroupModify(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
		
	}

	public void submitGroupModify() {
		click(By.name("update"));
		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length()- ")".length());
			groups.add(group);			
		}	
		return groups;
	}

}
