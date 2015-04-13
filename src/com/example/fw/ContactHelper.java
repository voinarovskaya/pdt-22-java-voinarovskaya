package com.example.fw;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}	
	
	public ContactHelper createdContact(ContactData contact) {
		gotoAddContact();
		fiilFormContact(contact);
		submitAddContact();		
		return this;
	}

	public ContactHelper deleteContact(int index) {
		initContactModify(index);   
	    submitContactDelete();	   
	    return this;
		
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModify(index);			
	    fiilFormContact(contact);
	    submitContactModify();	   
	    return this;		
	}		
	
	public ContactHelper fiilFormContact(ContactData contact) {
		input(By.name("firstname"), contact.getFirstname());
		input(By.name("lastname"), contact.getLastname());
		input(By.name("address"), contact.getAddress());
		input(By.name("home"), contact.getHome());
		input(By.name("mobile"), contact.getMobile());
		input(By.name("work"), contact.getWork());
		input(By.name("email"), contact.getEmail());
		input(By.name("email2"), contact.getEmail2());
		input(By.name("byear"), contact.getBirthyear());
		input(By.name("address2"), contact.getAddress2());
		input(By.name("phone2"), contact.getPhone2());	   
		select(By.name("bday"), contact.getBirthday());
		select(By.name("bmonth"), contact.getBitrhmonth());
		if (contact.getGroup() != null) {
			select(By.name("new_group"), contact.getGroup());   
		}
		return this;		
	}
	
	public ContactData infoFromForm() {
		ContactData contact = new ContactData();
		contact.setFirstname(getText(By.name("firstname")));  
		contact.setLastname(getText(By.name("lastname")));
		contact.setAddress(getText(By.name("address")));
		contact.setHome(getText(By.name("home")));
		contact.setMobile(getText(By.name("mobile")));
		contact.setWork(getText(By.name("work")));
		contact.setEmail(getText(By.name("email")));
		contact.setEmail2(getText(By.name("email2")));
		contact.setBirthyear(getText(By.name("byear"))); 
		contact.setAddress2(getText(By.name("address2")));
		contact.setPhone2(getText(By.name("phone2")));
		contact.setBirthday(getText(By.name("bday")));
		contact.setBitrhmonth(getText(By.name("bmonth")));	
		return  contact;		
	}
	
	
	
	public ContactHelper submitAddContact() {		
		click(By.name("submit"));		
		return this;
	}

	public void gotoAddContact() {
		click(By.linkText("add new"));		
	}
	
	public void initContactModify(int index) {
		click(By.xpath("//*[@name='entry'][" + (index + 1) +"]/td[7]/a"));
	}
	
	public ContactHelper submitContactModify() {		
		click(By.xpath("//*[@value='Update']"));		
		return this;
	}	
	
	public ContactHelper submitContactDelete() {		
		click(By.xpath("//*[@value='Delete']"));		
		return this;
	}

	public SortedListOf<ContactData> getContact() {
		manager.getNavigationHelper().openMainPage();
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {			
			contacts.add(new ContactData().
					withFirstname(row.findElement(By.xpath(".//td[3]")).getText()).
					withLastname(row.findElement(By.xpath(".//td[2]")).getText()));							
		}		
		return contacts;
	}

	private List<WebElement> getContactRows() {
		return  driver.findElements(By.xpath("//*[@id='maintable']//tr[@name='entry']"));		
	}	
	
}
