package com.kokai.controller;

import com.kokai.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.kokai.service.itemsService;

import java.util.List;

@ComponentScan(basePackages = "com.kokai.service")
 //Allow your port below and also in [WebConfig.addCorsMappings]
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:63342"})
@RestController
@RequestMapping("/itens")
public class shoppingListController {

    @Autowired
    private itemsService itemsService;


    @PostMapping
    public List<Items> createItems(@RequestBody Items Item){
        return itemsService.createItems(Item);
    }

    @GetMapping
    public List<Items> listItens(){
        return itemsService.listItems();
    }

    @PutMapping(path = "{id}")
    public List<Items> updateItens(@PathVariable("id") Long id, @RequestBody Items Item) throws Exception {
        return itemsService.updateItems(id,Item);
    }

    @DeleteMapping(path = "{id}")
    public List<Items> deleteItens(@PathVariable("id") Long id){
        return itemsService.deleteItems(id);
    }

    @DeleteMapping(path = "all")
    public List<Items> deleteAllItems(){
        return itemsService.deleteAllItems();
    }

}
