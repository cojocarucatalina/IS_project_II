package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;

import java.util.List;

public interface PetService {

    public PetDto getPetById(Integer id);
    List<PetDto> getAllPets();

    PetDto createPet(Pet pet);
    void save(Pet pet);

    PetDto updatePet(Pet pet);

    void deletePet(Pet pet);

    void deletePetById(Integer id);
}
