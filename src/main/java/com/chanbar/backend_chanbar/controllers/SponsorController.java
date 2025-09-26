package com.chanbar.backend_chanbar.controllers;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.services.ISponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sponsor")
public class SponsorController {
    private final ISponsorService sponsorService;

    @PostMapping
    SponsorDTO createSponsor(@RequestBody SponsorDTO sponsorDTO){
        return sponsorService.createSponsor(sponsorDTO);
    }
    @GetMapping
    List<SponsorDTO> getAllSponsor(){
        return sponsorService.getAllSponsor();
    }
    @DeleteMapping("/{id}")
    void deleteSponsor(@PathVariable(name = "id") Long id){
        sponsorService.deleteSponsor(id);
    };

}
