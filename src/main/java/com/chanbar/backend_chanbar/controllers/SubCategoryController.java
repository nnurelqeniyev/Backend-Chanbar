package com.chanbar.backend_chanbar.controllers;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;
import com.chanbar.backend_chanbar.DTOs.SubCategoryDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.SubCategory;
import com.chanbar.backend_chanbar.services.ISubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scategory")
public class SubCategoryController {
    private final ISubCategoryService subCategoryService;

    @PostMapping
    SubCategoryDTO createSCategory(@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryService.createSCategory(subCategoryDTO);
    };
    @GetMapping
    List<SubCategoryDTO> getAllSubCategory(){
        return subCategoryService.getAllSCategory();
    };
}
