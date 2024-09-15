package com.kokai.service;

import com.kokai.entity.Items;
import com.kokai.repository.itemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@ComponentScan(basePackages = "com.kokai.repository", basePackageClasses = {Items.class})
@Service
public class itemsService {

    @Autowired
    private itemsRepository itemsRepository;

    public itemsService(itemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> createItems(Items items) {
        items.onCreate();
        itemsRepository.save(items);
        return listItems();
    }
    public List<Items> listItems() {
        Sort sort = Sort.by("priority").ascending().and(
                Sort.by("name").ascending());
        return itemsRepository.findAll(sort);
    }

    public List<Items> updateItems(Long id, Items updatedItem) throws Exception {
        Exception Exception = new Exception("Item not found");
        Object Object = itemsRepository.findById(id).isPresent() ? itemsRepository.findById(id).get() : Exception;

        if (Object == Exception) {
            throw Exception;
        }
        else{
            Items itemToUpdate = (Items) Object;
            updatedItem.setId(id);
            if (updatedItem.getName() == null) {
                updatedItem.setName(itemToUpdate.getName());
            }
            if (updatedItem.getQuantity() == null) {
                updatedItem.setQuantity(itemToUpdate.getQuantity());
            }
            if (updatedItem.getPriority() == null) {
                updatedItem.setPriority(itemToUpdate.getPriority());
            }
            if (updatedItem.getStatus() == null) {
                updatedItem.setStatus(itemToUpdate.getStatus());
            }
            updatedItem.setCreationDate(itemToUpdate.getCreationDate());
        }
        itemsRepository.save(updatedItem);
        return listItems();
    }


    public List<Items> deleteItems(Long id) {
        itemsRepository.deleteById(id);
        return listItems();
    }

    public List<Items> deleteAllItems() {
        itemsRepository.deleteAll();
        return listItems();
    }

}
