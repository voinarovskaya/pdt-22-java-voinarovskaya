package com.example.tests;

import org.testng.annotations.Test;

public class ContactTests extends TestBase {  
 
  @Test
  public void testNonEmptyCreationsContact() throws Exception {	  
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoAddContact();
    ContactData contact = new ContactData();
    contact.firstname = "alisa";
    contact.lastname = "voinarovskaya";
    contact.address = "sity";
    contact.address2 = "my";
    contact.home = "street";
    contact.email = "@mail.ru";
    contact.email2 = "gmail.com";
    contact.work = "job";
    contact.phone2 = "+0";
    contact.group = "Rob";
    contact.birthday = "5";
    contact.birthyear = "2014";
    contact.bitrhmonth = "February";    
    app.getContactHelper().fiilFormContact(contact);
    app.getContactHelper().submitAddContact();
    app.getNavigationHelper().gotoHomePage();
  }
  
  @Test
  public void testContactDelete() throws Exception {	  
	app.getNavigationHelper().openMainPage();    
	app.getContactHelper().initContactModify(1);   
    app.getContactHelper().submitContactDelete();
    app.getNavigationHelper().gotoHomePage();
  }
  
  @Test
  public void testContactModify() throws Exception {	  
	app.getNavigationHelper().openMainPage();	
	app.getContactHelper().initContactModify(1);
    ContactData contact = new ContactData();
    contact.firstname = "alisavoinarovskaya";   
    app.getContactHelper().fiilFormContact(contact);
    app.getContactHelper().submitContactModify();
    app.getNavigationHelper().gotoHomePage();
  }
 
}
