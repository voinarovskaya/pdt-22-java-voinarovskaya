package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactTests extends TestBase {  
	
	
  @Test(dataProvider = "randomContactValidGenerator")
  public void testNonEmptyCreationsContact(ContactData contact) throws Exception {	  
	app.getNavigationHelper().openMainPage();
	
	List<ContactData> oldList = app.getContactHelper().getContact();
	
    app.getContactHelper().gotoAddContact();       
   
    app.getContactHelper().fiilFormContact(contact);
    app.getContactHelper().submitAddContact();
    app.getNavigationHelper().gotoHomePage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.add(contact);
    Collections.sort(oldList);    
    assertEquals(oldList.size(), newList.size());
  }
  
  @Test
  public void testContactDelete() throws Exception {	  
	app.getNavigationHelper().openMainPage();    
	
	List<ContactData> oldList = app.getContactHelper().getContact();
	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
	app.getContactHelper().initContactModify(index);   
    app.getContactHelper().submitContactDelete();
    app.getNavigationHelper().gotoHomePage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.remove(index);
    Collections.sort(oldList);    
    assertEquals(oldList.size(), newList.size());
  }
  
  @Test(dataProvider = "randomContactValidGenerator")
  public void testContactModify(ContactData contact) throws Exception {	  
	app.getNavigationHelper().openMainPage();
	
	List<ContactData> oldList = app.getContactHelper().getContact();
	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
	app.getContactHelper().initContactModify(index);
    
    app.getContactHelper().fiilFormContact(contact);
    app.getContactHelper().submitContactModify();
    app.getNavigationHelper().gotoHomePage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.remove(index);
    oldList.add(contact);
    Collections.sort(oldList);    
    assertEquals(oldList.size(), newList.size());
  }
 
}
