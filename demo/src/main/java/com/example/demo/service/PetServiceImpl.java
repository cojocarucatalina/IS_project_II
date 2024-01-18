package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.mapper.PetMapper;
import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public PetDto getPetById(Integer id){
        return petMapper.petEntityToDto(petRepository.findById(id).orElse(null));

    }
    public List<PetDto> getAllPets(){
        return petMapper.petListEntityToDto(petRepository.findAll());
    }

    public PetDto createPet(Pet pet){
        return petMapper.petEntityToDto(petRepository.save(pet));
    }
    public void save(Pet pet){
        petRepository.save(pet);
    }

    public PetDto updatePet(Pet pet){
        return petMapper.petEntityToDto(petRepository.save(pet));
    }

    public void deletePet(Pet pet){
        petRepository.delete(pet);
    }

    public void deletePetById(Integer id){
        petRepository.deleteById(id);
    }
}
