package com.example.fw;

import org.openqa.selenium.By;

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
		click(By.xpath("//*[@name='selected[]'][" + index + "]"));
	}

	public void initGroupModify(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
		
	}

	public void submitGroupModify() {
		click(By.name("update"));
		
	}

}
