package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupTests extends TestBase{	
	
  @Test(dataProvider = "randomDataValidGenerator")
  public void testGroupCreationValid(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    app.getGroupHelper().initGroupGreated();   
    app.getGroupHelper().fiilGroupForm(group);
    app.getGroupHelper().submitGroupGreation();
    app.getGroupHelper().returnToGroupsPage();
    
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    oldList.add(group);
    Collections.sort(oldList);    
    assertEquals(oldList, newList);
  }
 
  @Test
  public void testGroupDeleteValid() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
       
    List<GroupData> oldList = app.getGroupHelper().getGroups();    
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
    app.getGroupHelper().initGroupDelete(index);
    app.getGroupHelper().returnToGroupsPage();
    
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    oldList.remove(index);
    Collections.sort(oldList);    
    assertEquals(oldList, newList);
  }
  
  @Test(dataProvider = "randomDataValidGenerator")
  public void testGroupModifyValid(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    
    List<GroupData> oldList = app.getGroupHelper().getGroups();    
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
    app.getGroupHelper().initGroupModify(index);
   
    app.getGroupHelper().fiilGroupForm(group);
    app.getGroupHelper().submitGroupModify();
    app.getGroupHelper().returnToGroupsPage();
    
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    oldList.remove(index);
    oldList.add(group);
    Collections.sort(oldList);    
    assertEquals(oldList, newList);
  }
}
