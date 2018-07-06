package com.examle.demo.service;

import com.examle.demo.data.ItemRepository;
import com.examle.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

  @Autowired
  private ItemRepository itemRepository;

  public Item retrieveHardCodedItem() {
    return new Item(1, "Ball", 10, 100);
  }

  public List<Item> retrieveAllitems(){
    List<Item> result = itemRepository.findAll();
    for (Item item : result){
      item.setValue(item.getPrice()*item.getQuantity());
    }

    return result;
  }
}
