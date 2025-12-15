package com.example.inventory_service;

import org.springframework.web.bind.annotation.*;
import com.example.inventory_service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity){
        return inventoryService.isInStock(skuCode, quantity);
    }
}
