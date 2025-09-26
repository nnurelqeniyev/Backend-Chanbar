package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.SponsorDTO;
import com.chanbar.backend_chanbar.DTOs.SubCategoryDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.SubCategory;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.SponsorRepository;
import com.chanbar.backend_chanbar.repositories.SubCategoryRepository;
import com.chanbar.backend_chanbar.services.ISubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements ISubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    @Override
    public SubCategoryDTO createSCategory(SubCategoryDTO subCategoryDTO) {

        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());

        subCategoryRepository.save(subCategory);

        SubCategoryDTO subCategoryDTO1 = new SubCategoryDTO();
        subCategoryDTO1.setSubCategoryName(subCategory.getSubCategoryName());
        return subCategoryDTO1;
    }

    @Override
    public List<SubCategoryDTO> getAllSCategory() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        List<SubCategoryDTO> subCategoryDTOList = new ArrayList<>();

        for (SubCategory subCategory : subCategoryList){
            SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
            subCategoryDTO.setSubCategoryName(subCategory.getSubCategoryName());
            subCategoryDTOList.add(subCategoryDTO);
        }
        return subCategoryDTOList;
    }
}
