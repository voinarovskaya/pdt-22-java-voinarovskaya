package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	private SortedListOf<ContactData> cachedContact;
	
	public ContactHelper createdContact(ContactData contact) {
		gotoAddContact();
		fiilFormContact(contact);
		submitAddContact();
		rebuilCash();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		initContactModify(index);   
	    submitContactDelete();
	    rebuilCash();
	    return this;
		
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModify(index);	    
	    fiilFormContact(contact);
	    submitContactModify();
	    rebuilCash();
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
	
	public ContactHelper submitAddContact() {		
		click(By.name("submit"));	
		cachedContact = null;
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
		cachedContact = null;
		return this;
	}

	public SortedListOf<ContactData> getContact() {
		if (cachedContact == null) {
			rebuilCash();
		}		
		return cachedContact;
	}

	private void rebuilCash() {
		manager.getNavigationHelper().openMainPage();
		cachedContact = new SortedListOf<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {			
			cachedContact.add(new ContactData().
					withFirstname(row.findElement(By.xpath(".//td[3]")).getText()).
					withLastname(row.findElement(By.xpath(".//td[2]")).getText()));							
		}			
	}

	private List<WebElement> getContactRows() {
		return  driver.findElements(By.xpath("//*[@id='maintable']//tr[@name='entry']"));		
	}	
}
