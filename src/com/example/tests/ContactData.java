package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String birthday;
	private String bitrhmonth;
	
	private String birthyear;
	private String group;
	private String address2;
	private String phone2;

	public ContactData(String id, String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String birthday, String bitrhmonth,
			String birthyear, String group, String address2, String phone2) {
		this.id = id;
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
				return 0;
			}
		}		
	}
	
	
	
	public ContactData withId(String id) {
		this.id = id;
		return this;
	}
	public ContactData withFirstname(String firthname) {
		this.firstname = firthname;
		return this;
	}
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	public ContactData withBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}
	public ContactData withBirthyear(String birthyear) {
		this.birthyear = birthyear;
		return this;
	}
	public ContactData withBirthmonth(String bitrhmonth) {
		this.bitrhmonth = bitrhmonth;
		return this;
	}
	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getHome() {
		return home;
	}
	public String getMobile() {
		return mobile;
	}
	public String getWork() {
		return work;
	}
	public String getEmail() {
		return email;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getBitrhmonth() {
		return bitrhmonth;
	}
	public String getBirthyear() {
		return birthyear;
	}
	public String getGroup() {
		return group;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone2() {
		return phone2;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setBitrhmonth(String bitrhmonth) {
		this.bitrhmonth = bitrhmonth;
	}
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
	
	
	
}