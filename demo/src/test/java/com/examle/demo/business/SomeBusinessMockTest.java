package com.examle.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.examle.demo.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;

public class SomeBusinessMockTest {

  BusinessImpl  business = new BusinessImpl();
  SomeDataService someDataServiceMock = mock(SomeDataService.class);

  @Before
  public void before(){
    System.out.println("called..");
    business.setSomeDataService(someDataServiceMock);
  }


  @Test
  public void calculateSome_basic(){

    when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3});
    assertEquals(business.calculateSumUsingDataService(), 6);
  }

  @Test
  public void calculateSome_empty(){

    when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{});
    assertEquals(business.calculateSumUsingDataService(), 0);
  }

  @Test
  public void calculateSome_one(){

    when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1});
    assertEquals(business.calculateSumUsingDataService(), 1);
  }
}
