package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void submitAddContact() {		
		click(By.name("submit"));
	}

	public void gotoAddContact() {
		click(By.linkText("add new"));		
	}

	public void fiilFormContact(ContactData contact) {
		input(By.name("firstname"), contact.firstname);
		input(By.name("lastname"), contact.lastname);
		input(By.name("address"), contact.address);
		input(By.name("home"), contact.home);
		input(By.name("mobile"), contact.mobile);
		input(By.name("work"), contact.work);
		input(By.name("email"), contact.email);
		input(By.name("email2"), contact.email2);
		input(By.name("byear"), contact.birthyear);
		input(By.name("address2"), contact.address2);
		input(By.name("phone2"), contact.phone2);	   
		select(By.name("bday"), contact.birthday);
		select(By.name("bmonth"), contact.bitrhmonth);
		select(By.name("new_group"), contact.group);   
	}
}
