package com.example.tests;


import org.testng.annotations.Test;

public class AddGroupTests extends TestBase{
  @Test
  public void testNoEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupGreated();
    GroupData group = new GroupData();
    group.groupname="alisa";
    group.groupheader="voina";
    group.groupfooter="alisavoina";   
	fiilGroupForm(group);
    submitGroupGreation();
    returnToGroupsPage();
  }
  

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupGreated();
    GroupData group = new GroupData("","",""); 
    fiilGroupForm(group);
    submitGroupGreation();
    returnToGroupsPage();
  }
}
