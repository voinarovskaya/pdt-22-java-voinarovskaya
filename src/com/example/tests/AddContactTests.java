package com.example.tests;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {  
 
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
 
}
