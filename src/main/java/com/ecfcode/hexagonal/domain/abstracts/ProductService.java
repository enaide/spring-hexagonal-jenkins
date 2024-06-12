package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.requests.products.CreateProductRequest;
import com.ecfcode.hexagonal.domain.requests.products.DeleteProductRequest;
import com.ecfcode.hexagonal.domain.requests.products.UpdateProductRequest;
import com.ecfcode.hexagonal.domain.responses.dtos.PageableResponse;
import com.ecfcode.hexagonal.domain.responses.products.ProductGetResponse;
import com.ecfcode.hexagonal.domain.responses.products.ProductListResponse;

import java.util.List;

public interface ProductService {
	
	Result add(CreateProductRequest createProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	
	DataResult<ProductGetResponse> getById(int id);
	DataResult<List<ProductListResponse>> getAll();
	
	DataResult<List<ProductListResponse>> getAll(int pageNo,int pageSize);
	PageableResponse<List<ProductListResponse>> getAllByPage(int pageNo, int pageSize);
	DataResult<List<ProductListResponse>> getAllSortedByAsc(String field);
	DataResult<List<ProductListResponse>> getAllSortedByDesc(String field);
	
}
