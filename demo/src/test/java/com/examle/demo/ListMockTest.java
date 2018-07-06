package com.examle.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

public class ListMockTest {

  List<String> mock = mock(List.class);

  @Test
  public void size_basic(){
    when(mock.size()).thenReturn(5);
    assertEquals(5, mock.size());
  }

  @Test
  public void size_multple_values(){
    when(mock.size()).thenReturn(5).thenReturn(2);
    assertEquals(5, mock.size());
    assertEquals(2, mock.size());
  }

  @Test
  public void retunrWithParameters(){
    when(mock.get(1)).thenReturn("mock testing");
    assertEquals(mock.get(0), null);
    assertEquals(mock.get(1), "mock testing");
  }

  @Test
  public void retunrWithGenericParameters(){
    when(mock.get(anyInt())).thenReturn("mock testing");
    assertEquals(mock.get(0), "mock testing");
    assertEquals(mock.get(1), "mock testing");
  }

  @Test
  public void verificationBasic(){
    String ele = mock.get(0);
    String ele2 = mock.get(1);
    String ele3 = mock.get(2);

    verify(mock).get(0);
    // verify specific method call with specific value specific number of times
    verify(mock, times(3)).get(anyInt());
    verify(mock, never()).get(3);
    //verify(mock, atLeastOnce()).get(anyInt());
  }

  @Test
  public void argumentCapturing(){

    mock.add("add something");

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    // capture what value is passed to method we want to verify
    verify(mock).add(captor.capture());

    assertEquals("add something", captor.getValue());


  }
}
