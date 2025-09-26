package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.CategoryDTO;
import com.chanbar.backend_chanbar.models.Category;
import com.chanbar.backend_chanbar.repositories.CategoryRepository;
import com.chanbar.backend_chanbar.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;



    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryDTO newCategory = new CategoryDTO();
        Category category = new Category();

        category.setCategoryName(categoryDTO.getCategoryName());

        categoryRepository.save(category);

        newCategory.setCategoryName(categoryDTO.getCategoryName());

        return newCategory;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
