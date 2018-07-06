package com.examle.demo.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.examle.demo.model.Item;
import com.examle.demo.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private ItemBusinessService itemBusinessService;

  @Test
  public void testItemController() throws Exception {

    RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().json("{\n" +
            "\"id\": 1,\n" +
            "\"name\": \"Ball\",\n" +
            "\"price\": 10,\n" +
            "\"quantity\": 100\n" +
            "}")).andReturn();

    String expected = "{\n" +
        "\"id\": 1,\n" +
        "\"name\": \"Ball\",\n" +
        "\"price\": 10,\n" +
        "\"quantity\":  100\n" +
        "}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void testItemController_mock() throws Exception {

    when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item(2, "item2", 10, 10));

    RequestBuilder request = MockMvcRequestBuilders.get("/item-from-service").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().json("{id:2, name: item2, price:10}")).andReturn();

    String expected = "{id:2, name: item2, price:10}";

    //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }


  @Test
  public void retrieveAll() throws Exception {

    when(itemBusinessService.retrieveAllitems()).thenReturn(Arrays.asList(new Item(2, "item2", 10, 20),
        new Item(2, "item3", 20, 10)));

    RequestBuilder request = MockMvcRequestBuilders.get("/all-items").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
        .andExpect(content().json("[{id:2, name: item2, price:10},{id:2, name: item3, price:20}]")).andReturn();
    //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }
}
