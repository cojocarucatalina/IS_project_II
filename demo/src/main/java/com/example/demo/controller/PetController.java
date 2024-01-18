package com.example.demo.controller;

import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("pets")
public class PetController {

    private final PetService petService;

    @GetMapping()
    public String getPets(Model model){
        List<PetDto> petsDtos = petService.getAllPets();
        model.addAttribute("name","Pets");
        model.addAttribute("pets",petsDtos);
        return "pets/index";
    }


    @GetMapping("/{id}")
    public PetDto getPetById(@PathVariable Integer id){
        return petService.getPetById(id);
    }

    @GetMapping("/add")
    public String displayCreatePetForm(Model model) {
        model.addAttribute("title", "Add Pet");
        model.addAttribute(new Pet());
        return "/add";
    }
    @PostMapping("/add")
    public String processCreatePetForm(@ModelAttribute Pet newPet, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pet");
            return "/add";
        }
        petService.save(newPet);
        return "redirect:/pets";
    }

    @GetMapping("/delete")
    public String displayDeletePetForm(Model model) {
        model.addAttribute("name", "Delete Pets");
        model.addAttribute("pets", petService.getAllPets());
        return "/delete";
    }

    @PostMapping("/delete")
    public String processDeletePetsForm(@RequestParam(required = false) Integer[] petIds) {
        if (petIds != null) {
            for (Integer id : petIds) {
                petService.deletePetById(id);
            }
        }
        return "redirect:/pets";
    }


}


