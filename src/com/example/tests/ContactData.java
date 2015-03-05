package com.example.tests;

import java.util.Comparator;



public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String birthday;
	public String bitrhmonth;
	public String birthyear;
	public String group;
	public String address2;
	public String phone2;

	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String birthday, String bitrhmonth,
			String birthyear, String group, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.birthday = birthday;
		this.bitrhmonth = bitrhmonth;
		this.birthyear = birthyear;
		this.group = group;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	public ContactData() {
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", home=" + home + ", work=" + work + "]";
	}		
	
	
	public int compareString(String thiss, String other) {		
		 
		 if (thiss.toLowerCase().compareTo(other.toLowerCase()) != 0) {
			 return thiss.toLowerCase().compareTo(other.toLowerCase());
		 } else {
			 return 0;
		 }		
	}
	
	@Override
	public int compareTo(ContactData other) {
		if (compareString(this.lastname, other.lastname) != 0) {
			return compareString(this.lastname, other.lastname);			
		} else {
			if (compareString(this.firstname, other.firstname) != 0) {
				return compareString(this.firstname, other.firstname);			
			} else {
				if (compareString(this.home, other.home) != 0) {
					return compareString(this.home, other.home);			
				} else {
					if (compareString(this.email, other.email) != 0) {
						return compareString(this.email, other.email);			
					} else {
						return 0;
					}
				}
			}
		}		
	}
	
	
	
	
	
}