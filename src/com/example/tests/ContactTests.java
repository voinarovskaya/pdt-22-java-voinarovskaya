package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactTests extends TestBase {  
	
	static Comparator<ContactData> snorderer = new Comparator<ContactData>() {

        public int compare(ContactData o1, ContactData o2) {
            return o1.firstname.compareTo(o2.firstname);
        }
    };
	
  @Test(dataProvider = "randomContactValidGenerator")
  public void testCreationsContact(ContactData contact) throws Exception {	  
	app.getNavigationHelper().openMainPage();
	
	List<ContactData> oldList = app.getContactHelper().getContact();
	
    app.getContactHelper().gotoAddContact();       
   
    app.getContactHelper().fiilFormContact(contact);
    app.getContactHelper().submitAddContact();
    app.getNavigationHelper().openMainPage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.add(contact);
    Collections.sort(oldList, snorderer);   
    Collections.sort(newList, snorderer); 
    assertEquals(oldList, newList);
  }
  
  @Test
  public void testContactDelete() throws Exception {	  
	app.getNavigationHelper().openMainPage();    
	
	List<ContactData> oldList = app.getContactHelper().getContact();
	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
	app.getContactHelper().initContactModify(index);   
    app.getContactHelper().submitContactDelete();
    app.getNavigationHelper().openMainPage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.remove(index);
    Collections.sort(oldList, snorderer);   
    Collections.sort(newList, snorderer);    
    assertEquals(oldList, newList);
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
    app.getNavigationHelper().openMainPage();
    
    List<ContactData> newList = app.getContactHelper().getContact();  
    
    oldList.remove(index);
    oldList.add(contact);
    Collections.sort(oldList, snorderer);   
    Collections.sort(newList, snorderer);  
    assertEquals(oldList, newList);
  }
 
}
