package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactTests extends TestBase {  
	
	static Comparator<ContactData> snorderer = new Comparator<ContactData>() {

        public int compare(ContactData o1, ContactData o2) {
            return o1.getFirstname().compareTo(o2.getFirstname());
        }
    };
    
    @DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactForProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();	
	}
	
  @Test(dataProvider = "contactsFromFile")
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
  
  @Test(dataProvider = "contactsFromFile")
  public void testContactModify(ContactData contact) throws Exception {
	SortedListOf<ContactData> oldList = app.getContactHelper().getContact();	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);    
	app.getContactHelper().modifyContact(index, contact);    
    SortedListOf<ContactData> newList = app.getContactHelper().getContact();  
    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));   
  } 
}
