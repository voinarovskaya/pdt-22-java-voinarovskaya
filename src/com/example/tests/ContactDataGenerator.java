package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Ознакомтесь с необходимым количеством параметров");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format =  args[2];
		
		if (file.exists()) {
			System.out.println("Удали файл сам " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);			
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);	
		} else {
			System.out.println("Неизвестный форма" + format);
			return;		
		}

	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}
	
	public static List<GroupData> loadContactsToXmlFile(File file) {
		XStream xstream = new XStream();
		return (List<GroupData>) xstream.fromXML(file);
		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getAddress2() + 
					"," + contact.getBirthday() + "," + contact.getBirthyear() + "," + contact.getBitrhmonth() + "," + contact.getEmail() + 
					"," + contact.getEmail2() + "," + contact.getMobile() + "," +  contact.getWork() +"," +  contact.getHome() + ",!" + "\n");
		}
		writer.close();		
	}
	

	 public static  List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		
		 List<ContactData> list = new ArrayList<ContactData>();		
		 FileReader reader = new FileReader(file);
		 BufferedReader bufferedReader = new BufferedReader(reader);
		 String line = bufferedReader.readLine();
		 while (line != null) {
			 String[] part = line.split(",");
			 ContactData contact = new ContactData()
			 .withFirstname(part[0])
			 .withLastname(part[1])
			 .withAddress(part[2])
			 .withAddress2(part[3])
			 .withBirthday(part[4])
			 .withBirthyear(part[5])
			 .withBirthmonth(part[6])
			 .withEmail(part[7])
			 .withEmail2(part[8])
			 .withPhone2(part[9])
			 .withWork(part[10])
			 .withHome(part[11]);			 
			 list.add(contact);
			 line = bufferedReader.readLine();
		}
		 bufferedReader.close();
		 return list;			
		}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();		
		for (int i = 0; i < amount; i++) {
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
					withBirthmonth("February").
					withWork(generateRandomNmberPhone()).
					withHome(generateRandomNmberPhone());
			
			list.add(contact);			
		}
		return list;		
	}
	
	public static String generateRandomNmberPhone(){
		Random rnd = new Random();
		String work = null;
		for (int j = 0; j < 9; j++) {
	    	work = work + rnd.nextInt(9);
		}
		return work;
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";		
		} else {
			return "text" + rnd.nextInt();
		}
	}
	

}
