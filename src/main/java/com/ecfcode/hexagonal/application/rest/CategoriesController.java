package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.abstracts.CategoryService;

import com.ecfcode.hexagonal.domain.requests.categories.CreateCategoryRequest;
import com.ecfcode.hexagonal.domain.requests.categories.DeleteCategoryRequest;
import com.ecfcode.hexagonal.domain.requests.categories.UpdateCategoryRequest;
import com.ecfcode.hexagonal.domain.responses.categories.CategoryGetResponse;
import com.ecfcode.hexagonal.domain.responses.categories.CategoryListResponse;
import com.ecfcode.hexagonal.domain.responses.dtos.PageableResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
		return this.categoryService.add(createCategoryRequest);
	}

	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteCategoryRequest deleteCategoryRequest) {
		return this.categoryService.delete(deleteCategoryRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
		return this.categoryService.update(updateCategoryRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<CategoryGetResponse> getbById(@RequestParam int id) {
		return this.categoryService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<CategoryListResponse>> getAll() {
		return this.categoryService.getAll();
	}

	@GetMapping("/getallbypage")
	public PageableResponse<List<CategoryListResponse>> getAllByPage(int pageNo, int pageSize) {
		return this.categoryService.getAllByPage(pageNo,pageSize);
	}
	
	
}
