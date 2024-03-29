package com.example.sisterslabapi.service;

import com.example.sisterslabapi.dto.converter.CategoryConverter;
import com.example.sisterslabapi.dto.converter.MovieConverter;
import com.example.sisterslabapi.dto.request.category.CreateCategoryRequest;
import com.example.sisterslabapi.dto.request.category.UpdateCategoryRequest;
import com.example.sisterslabapi.dto.response.category.CreateCategoryResponse;
import com.example.sisterslabapi.dto.response.category.GetCategoryResponse;
import com.example.sisterslabapi.dto.response.category.UpdateCategoryResponse;
import com.example.sisterslabapi.exception.CategoryIdNotFoundException;
import com.example.sisterslabapi.exception.Constant;
import com.example.sisterslabapi.model.Category;
import com.example.sisterslabapi.repository.CategoryRepository;
import com.example.sisterslabapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryConverter converter;

    public void deleteCategory(Long id) {
        repository.delete(findById(id));
    }

    public CreateCategoryResponse create(CreateCategoryRequest request) {
        return converter.convertEntityToCreateResponse(converter.convertCreateRequestToEntity(request));
    }

    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        return converter.convertEntityToUpdateResponse(converter.convertUpdateToEntity(request));
    }

    public UpdateCategoryResponse updateNameById(UpdateCategoryRequest request) {
        findById(request.id()).setName(request.name());
        return converter.convertEntityToUpdateResponse(findById(request.id()));
    }

    public List<GetCategoryResponse> getAll() {
        return converter.convertEntityToGetAllResponse(repository.findAll());
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CategoryIdNotFoundException(Constant.CATEGORY_ID_NOT_FOUND));
    }
}
