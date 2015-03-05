package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	    
	  }
	
	@DataProvider
	public Iterator<Object[]> randomDataValidGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();		
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();			
			group.name =generateRandomString();
			group.header =generateRandomString();
			group.footer =generateRandomString();
			list.add(new Object[]{group});			
		}
		return list.iterator();
		
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";		
		} else {
			return "text" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomContactValidGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();		
		for (int i = 0; i < 2; i++) {
			Random rnd = new Random();
			ContactData contact = new ContactData();
			contact.firstname = "alisa" + rnd.nextInt();
		    contact.lastname = "voinarovskay" + rnd.nextInt();
		    contact.address = "street" + rnd.nextInt(10);
		    contact.address2 = "street" + rnd.nextInt(100);
		    contact.home = "home" + rnd.nextInt();
		    contact.email = rnd.nextInt() + "@mail.ru";
		    contact.email2 =rnd.nextInt() + "@gmail.com";
		    for (int j = 0; j < 9; j++) {
		    	 contact.work = contact.work + rnd.nextInt(9);
			}
		    for (int j = 0; j < 9; j++) {
		    	 contact.phone2 = contact.phone2 + rnd.nextInt(9);
			}		   
		    contact.birthday = String.valueOf(rnd.nextInt(28));
		    contact.birthyear = String.valueOf(1960 + rnd.nextInt(50));
		    contact.bitrhmonth = "February";  			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
