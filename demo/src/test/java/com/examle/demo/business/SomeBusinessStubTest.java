package com.examle.demo.business;

import static org.junit.Assert.assertEquals;

import com.examle.demo.data.SomeDataService;
import org.junit.Test;

class SomeDataServiceStub implements SomeDataService{

  @Override
  public int[] retriveAllData() {
    return new int[]{1,2,3};
  }
}

class SomeDataServiceEmptyStub implements SomeDataService{

  @Override
  public int[] retriveAllData() {
    return new int[]{};
  }
}

class SomeDataServiceOneStub implements SomeDataService{

  @Override
  public int[] retriveAllData() {
    return new int[]{1};
  }
}

public class SomeBusinessStubTest {

  @Test
  public void calculateSome_basic(){
    BusinessImpl  business = new BusinessImpl();
    business.setSomeDataService(new SomeDataServiceStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 6;
    assertEquals(actualResult, expectedResult);
  }

  @Test
  public void calculateSome_empty(){
    BusinessImpl  business = new BusinessImpl();
    business.setSomeDataService(new SomeDataServiceEmptyStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 0;
    assertEquals(actualResult, expectedResult);
  }

  @Test
  public void calculateSome_one(){
    BusinessImpl  business = new BusinessImpl();
    business.setSomeDataService(new SomeDataServiceOneStub());
    int actualResult = business.calculateSumUsingDataService();
    int expectedResult = 1;
    assertEquals(actualResult, expectedResult);
  }
}
