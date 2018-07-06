package com.examle.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.examle.demo.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockWithAnnotationsTest {

  @InjectMocks
  BusinessImpl  business;
  @Mock
  SomeDataService someDataServiceMock;

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
