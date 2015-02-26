package com.example.tests;


import org.testng.annotations.Test;

public class GroupTests extends TestBase{
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
  
  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupDelete(1);
    app.getGroupHelper().returnToGroupsPage();
  }
  
  @Test
  public void testGroupModify() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupModify(1);
    GroupData group = new GroupData(); 
    group.name="super alisa";
    group.header="super voina";
    group.footer="super alisavoina";   
    app.getGroupHelper().fiilGroupForm(group);
    app.getGroupHelper().submitGroupModify();
    app.getGroupHelper().returnToGroupsPage();
  }
}
