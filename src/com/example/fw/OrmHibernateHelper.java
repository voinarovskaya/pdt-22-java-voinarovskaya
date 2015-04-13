package com.example.fw;

import org.junit.Assert;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class OrmHibernateHelper extends WebDriverHelperBase {
	
	public OrmHibernateHelper(ApplicationManager manager)  {		
		super(manager);
		
	}

	public ContactData analiseContansInfo(SortedListOf<ContactData> oldList, ContactData contact)
	{	
		ContactData cont = new ContactData();
		for (ContactData contactData : oldList) {
			if (contactData.getFirstname().equals(contact.getFirstname())) {
				cont= contactData;
				break;
			}
		}
		return cont;
		
	}
	
	public void analise(SortedListOf<ContactData> oldList, ContactData contact){
		ContactData db = analiseContansInfo(oldList, contact);
		Assert.assertTrue(db.equals(contact));		
	}

}
