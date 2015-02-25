package com.example.tests;


import org.testng.annotations.Test;

public class AddGroupTests extends TestBase{
  @Test
  public void testNoEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupGreated();
    GroupData group = new GroupData();
    group.name="alisa";
    group.header="voina";
    group.footer="alisavoina";   
    app.getGroupHelper().fiilGroupForm(group);
    app.getGroupHelper().submitGroupGreation();
    app.getGroupHelper().returnToGroupsPage();
  }
  

  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupGreated();
    GroupData group = new GroupData("","",""); 
    app.getGroupHelper().fiilGroupForm(group);
    app.getGroupHelper().submitGroupGreation();
    app.getGroupHelper().returnToGroupsPage();
  }
}
