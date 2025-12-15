package com.example.inventory_service;

import com.example.inventory_service.InventoryRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class InventoryService{
    private  final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isInStock(String skuCode, int quantity){
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);

        if(inventory.isPresent() && inventory.get().getQuantity() >= quantity){
            return true;
        }else{
            return false;
        }
    }
}
