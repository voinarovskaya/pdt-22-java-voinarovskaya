package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupTests extends TestBase{	
	
  @Test(dataProvider = "randomDataValidGenerator")
  public void testGroupCreationValid(GroupData group) throws Exception {    
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    app.getGroupHelper().createdGroup(group);    	
    
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    assertThat(newList, equalTo(oldList.withAdded(group)));    
  }
 
  @Test
  public void testGroupDeleteValid() throws Exception {       
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();    
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
    app.getGroupHelper().deleteGroup(index); 
    
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    assertThat(newList, equalTo(oldList.without(index)));   
  }
  
  @Test(dataProvider = "randomDataValidGenerator")
  public void testGroupModifyValid(GroupData group) throws Exception {    
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();    
    
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
    app.getGroupHelper().modifyGroup(index, group);   
    
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));   
  }
}
