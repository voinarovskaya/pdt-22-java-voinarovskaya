package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		if (contact.group != null) {
			select(By.name("new_group"), contact.group);   
		}
		
	}

	public void initContactModify(int index) {
		click(By.xpath("//*[@name='entry'][" + (index + 1) +"]/td[7]/a"));
	}
	
	public void submitContactModify() {		
		click(By.xpath("//*[@value='Update']"));	
	}
	
	
	public void submitContactDelete() {		
		click(By.xpath("//*[@value='Delete']"));		
	}

	public List<ContactData> getContact() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("entry"));
		int i = 1;
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			contact.firstname = driver.findElement(By.xpath("//*[@name='entry'][" + i + "]/td[3]")).getText();
			contact.lastname = driver.findElement(By.xpath("//*[@name='entry'][" + i + "]/td[2]")).getText();
			contact.email = driver.findElement(By.xpath("//*[@name='entry'][" + i + "]/td[4]/a")).getText();
			contact.home = driver.findElement(By.xpath("//*[@name='entry'][" + i + "]/td[5]")).getText();
			i++;
			
			contacts.add(contact);			
		}	
		return contacts;
	}		
}
