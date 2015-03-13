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
		for (int i = 0; i < 1; i++) {
			GroupData group = new GroupData().
					withName(generateRandomString()).
					withHeader(generateRandomString()).
					withFooter(generateRandomString());		
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
	
	public String generateRandomNmberPhone(){
		Random rnd = new Random();
		String work = null;
		for (int j = 0; j < 9; j++) {
	    	work = work + rnd.nextInt(9);
		}
		return work;
	}
	
	@DataProvider
	public Iterator<Object[]> randomContactValidGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();		
		for (int i = 0; i < 1; i++) {
			Random rnd = new Random();
			ContactData contact = new ContactData().
					withFirstname("alisa" + rnd.nextInt()).
					withLastname("voinarovskay" + rnd.nextInt()).
					withAddress("street" + rnd.nextInt(10)).
					withAddress2("street" + rnd.nextInt(100)).
					withEmail(rnd.nextInt() + "@mail.ru").
					withEmail2(rnd.nextInt() + "@gmail.com").					
					withPhone2(generateRandomNmberPhone()).
					withBirthday(String.valueOf(rnd.nextInt(27) +1)).
					withBirthyear(String.valueOf(1960 + rnd.nextInt(50) +1)).
					withBirthmonth("February");			
			list.add(new Object[]{contact});			
		}
		return list.iterator();
	}

}
