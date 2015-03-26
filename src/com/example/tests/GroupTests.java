package com.example.tests;


import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class GroupTests extends TestBase{	
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
		return wrapGroupForProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();	
	}

 

@Test(dataProvider = "groupsFromFile")
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
