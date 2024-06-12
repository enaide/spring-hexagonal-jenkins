package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.domain.requests.categories.CreateCategoryRequest;
import com.ecfcode.hexagonal.domain.requests.categories.DeleteCategoryRequest;
import com.ecfcode.hexagonal.domain.requests.categories.UpdateCategoryRequest;

import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.responses.categories.CategoryGetResponse;
import com.ecfcode.hexagonal.domain.responses.categories.CategoryListResponse;
import com.ecfcode.hexagonal.domain.responses.dtos.PageableResponse;

import java.util.List;

public interface CategoryService {

	Result add(CreateCategoryRequest createCategoryRequest);
	Result delete(DeleteCategoryRequest deleteCategoryRequest);
	Result update(UpdateCategoryRequest updateCategoryRequest);
	
	DataResult<CategoryGetResponse> getById(int id);
	DataResult<List<CategoryListResponse>> getAll();
	
	PageableResponse<List<CategoryListResponse>> getAllByPage(int pageNo, int pageSize);
	
	 
}
