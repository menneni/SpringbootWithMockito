package com.examle.demo;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpyTest {

  @Test
  public void spyTesting(){

    // compared to mock, spy will keep context
    // if we use mock all size calls will return zero
    List<String> arrayList = spy(ArrayList.class);

    arrayList.add("test 1");
    System.out.println(arrayList.size());
    arrayList.add("test 2");
    System.out.println(arrayList.size());

    // but when we used when and return it always returns same result
    when(arrayList.size()).thenReturn(5);
    System.out.println(arrayList.size()); // returns 5 instead of 3

    arrayList.add("test4");
    verify(arrayList).add("test4");


  }
}
