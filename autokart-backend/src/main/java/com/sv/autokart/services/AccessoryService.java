package com.sv.autokart.services;

import com.sv.autokart.dtos.AccessoryListResponse;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.mapper.AccessoryMapper;
import com.sv.autokart.models.Accessory;
import com.sv.autokart.repositories.AccessoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private final AccessoryMapper accessoryMapper;

    @Transactional(readOnly = true)
    public List<AccessoryListResponse> getAllAccessories(){
        return accessoryRepository.findAll().stream().map(accessoryMapper::mapAccessoriesToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AccessoryListResponse> getAllAccessoriesByCategoryName(String categoryName){
        return accessoryRepository.findAllByCategoryName(categoryName).stream().map(accessoryMapper::mapAccessoriesToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Accessory getAccessoryById(Long id){
        Accessory accessory = accessoryRepository.findById(id).orElseThrow(()->new SpringAutoKartException("Accessory not found with id: "+id));
        return accessory;
    }

    @Transactional
    public void saveAccessory(Accessory accessory){
        accessoryRepository.save(accessory);
    }

    @Transactional
    public void updateAccessory(Long accessoryId, Accessory accessory){
        Accessory updatedAccessory = accessoryRepository.findById(accessoryId).orElseThrow(()->new SpringAutoKartException("Accessory not found with id: "+accessoryId));
        updatedAccessory.setCategories(accessory.getCategories());
        updatedAccessory.setColor(accessory.getColor());
        updatedAccessory.setCompatabilityModels(accessory.getCompatabilityModels());
        updatedAccessory.setDescription(accessory.getDescription());
        updatedAccessory.setMaterial(accessory.getMaterial());
        updatedAccessory.setImageUrl(accessory.getImageUrl());
        updatedAccessory.setPrice(accessory.getPrice());
        updatedAccessory.setTitle(accessory.getTitle());

        accessoryRepository.save(updatedAccessory);
    }

    @Transactional
    public void deleteAccessory(Long accessoryId){
        accessoryRepository.deleteById(accessoryId);
    }

}
