package com.sv.autokart.controllers;

import com.sv.autokart.dtos.AccessoryListResponse;
import com.sv.autokart.models.Accessory;
import com.sv.autokart.services.AccessoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accessories")
@AllArgsConstructor
public class AccessoryController {

    private final AccessoryService accessoryService;

    @GetMapping
    public ResponseEntity<List<AccessoryListResponse>> getAllAccessories(){
        return ResponseEntity.status(HttpStatus.OK).body(accessoryService.getAllAccessories());
    }

    @GetMapping("/{accessoryid}")
    public ResponseEntity<Accessory> getAccessory(@PathVariable Long accessoryid){
        return ResponseEntity.status(HttpStatus.OK).body(accessoryService.getAccessoryById(accessoryid));
    }

    @GetMapping("/category/{categoryname}")
    public ResponseEntity<List<AccessoryListResponse>> getAllAccessoriesByCategory(@PathVariable String categoryname){
        return ResponseEntity.status(HttpStatus.OK).body(accessoryService.getAllAccessoriesByCategoryName(categoryname));
    }

    @PostMapping
    public ResponseEntity<String> createNewAccessory(@RequestBody Accessory accessory){
        accessoryService.saveAccessory(accessory);
        return ResponseEntity.status(HttpStatus.CREATED).body("Accessory created successfully");
    }

    @PutMapping("/{accessoryid}")
    public ResponseEntity<String> updateAccessory(@PathVariable Long accessoryid, @RequestBody Accessory accessory){
        accessoryService.updateAccessory(accessoryid,accessory);
        return ResponseEntity.status(HttpStatus.OK).body("Accessory updated successfully");
    }

    @DeleteMapping("/{accessoryid}")
    public ResponseEntity<String> deleteAccessory(@PathVariable Long accessoryid){
        accessoryService.deleteAccessory(accessoryid);
        return ResponseEntity.status(HttpStatus.OK).body("Accessory deleted successfuuly");
    }
}
