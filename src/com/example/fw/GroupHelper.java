package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}	
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));	
		return this;
	}
	
	public GroupHelper createdGroup(GroupData group) {
		initGroupGreated();
    	fiilGroupForm(group);
    	submitGroupGreation();
    	returnToGroupsPage();    	
    	return this;
	}
	
	public GroupHelper fiilGroupForm(GroupData group) {
		input(By.name("group_name"), group.getName());
		input(By.name("group_header"), group.getHeader());
		input(By.name("group_footer"), group.getFooter());	
		return this;
	}	
	

	public GroupHelper modifyGroup(int index, GroupData group) {
		 initGroupModify(index);
		 fiilGroupForm(group);
		 submitGroupModify();
		 returnToGroupsPage();			
		 return this;
	}

	public GroupHelper deleteGroup(int index) {
		submitGroupDelete(index);
		returnToGroupsPage();		
		return this;
		
	}
	///------

	public GroupHelper submitGroupGreation() {		
		click(By.name("submit"));	
		return this;
	}

	public GroupHelper initGroupGreated()  {
		manager.getNavigationHelper().gotoGroupPage();
		click(By.name("new"));
		return this;
	}	

	public GroupHelper submitGroupDelete(int index) {		
		selectGroupByIndex(index);
		click(By.name("delete"));		
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//*[@name='selected[]'][" + (index +1) + "]"));
	}

	public void initGroupModify(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));		
	}

	public GroupHelper submitGroupModify() {
		click(By.name("update"));		
		return this;
		
	}

	public SortedListOf<GroupData> getGroups() {
		manager.getNavigationHelper().gotoGroupPage();
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {			
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()- ")".length());
			groups.add(new GroupData().withName(name));			
		}		
		return groups;
		
	}

	

	

}
