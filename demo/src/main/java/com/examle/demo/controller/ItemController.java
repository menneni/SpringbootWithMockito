package com.examle.demo.controller;

import com.examle.demo.model.Item;
import com.examle.demo.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

  @Autowired
  ItemBusinessService itemBusinessService;

  @GetMapping("/dummy-item")
  public Item helloItemController(){
    return new Item(1, "Ball", 10, 100);
  }

  @GetMapping("/item-from-service")
  public Item helloDummyFromService(){
      return itemBusinessService.retrieveHardCodedItem();
  }

  @GetMapping("/all-items")
  public List<Item> retrieveAll(){
    return itemBusinessService.retrieveAllitems();
  }
}
