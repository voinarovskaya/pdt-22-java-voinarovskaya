package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Comparator;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactTests extends TestBase {  
	
	static Comparator<ContactData> snorderer = new Comparator<ContactData>() {

        public int compare(ContactData o1, ContactData o2) {
            return o1.getFirstname().compareTo(o2.getFirstname());
        }
    };
	
  @Test(dataProvider = "randomContactValidGenerator")
  public void testCreationsContact(ContactData contact) throws Exception {	  
	SortedListOf<ContactData> oldList = app.getContactHelper().getContact();	
    app.getContactHelper().createdContact(contact);       
    SortedListOf<ContactData> newList = app.getContactHelper().getContact();    
    assertThat(newList, equalTo(oldList.withAdded(contact)));   
  }
  
  @Test
  public void testContactDelete() throws Exception {	  
	SortedListOf<ContactData> oldList = app.getContactHelper().getContact();	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);    
	app.getContactHelper().deleteContact(index);      
    SortedListOf<ContactData> newList = app.getContactHelper().getContact();      
    assertThat(newList, equalTo(oldList.without(index)));   
  }
  
  @Test(dataProvider = "randomContactValidGenerator")
  public void testContactModify(ContactData contact) throws Exception {
	SortedListOf<ContactData> oldList = app.getContactHelper().getContact();	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);    
	app.getContactHelper().modifyContact(index, contact);    
    SortedListOf<ContactData> newList = app.getContactHelper().getContact();  
    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));   
  } 
}
