package com.examle.demo.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

  @Test
  public void calculateSome_basic(){
    BusinessImpl  business = new BusinessImpl();
    int actualResult = business.calculateSum(new int[]{1,2,3});
    int expectedResult = 6;
    assertEquals(actualResult, expectedResult);
  }

  @Test
  public void calculateSome_empty(){
    BusinessImpl  business = new BusinessImpl();
    int actualResult = business.calculateSum(new int[]{});
    int expectedResult = 0;
    assertEquals(actualResult, expectedResult);
  }

  @Test
  public void calculateSome_one(){
    BusinessImpl  business = new BusinessImpl();
    int actualResult = business.calculateSum(new int[]{1});
    int expectedResult = 1;
    assertEquals(actualResult, expectedResult);
  }
}
