package com.example.demo.mapper;

import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PetMapper {

    public PetDto petEntityToDto(Pet pet){
        return PetDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .type(pet.getType())
                .age(pet.getAge())
                .build();
    }

    public List<PetDto> petListEntityToDto(List<Pet> pets){
        return pets.stream()
                .map(pet -> petEntityToDto(pet))
                .toList();
    }


    public Pet petDtoToEntity(PetDto petDto){
        return Pet.builder()
                .id(petDto.id())
                .name(petDto.name())
                .type(petDto.type())
                .age(petDto.age())
                .build();
    }

    public List<Pet> petListDtoToEntity(List<PetDto> petDtos){
        return petDtos.stream()
                .map(petDto -> petDtoToEntity(petDto))
                .toList();
    }

}
