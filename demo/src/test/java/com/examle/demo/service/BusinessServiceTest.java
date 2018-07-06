package com.examle.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.examle.demo.data.ItemRepository;
import com.examle.demo.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {

  @InjectMocks
  private ItemBusinessService itemBusinessService;

  @Mock
  private ItemRepository itemRepository;

  @Test
  public void retriveAllTest(){
    when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "item name", 15, 20)));
    assertEquals(itemBusinessService.retrieveAllitems().get(0).getValue(), 300);
  }

}
