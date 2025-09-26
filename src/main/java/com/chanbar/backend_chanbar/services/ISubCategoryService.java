package com.chanbar.backend_chanbar.services;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;
import com.chanbar.backend_chanbar.DTOs.SubCategoryDTO;
import com.chanbar.backend_chanbar.models.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    SubCategoryDTO createSCategory(SubCategoryDTO subCategoryDTO);

    List<SubCategoryDTO> getAllSCategory();
}
