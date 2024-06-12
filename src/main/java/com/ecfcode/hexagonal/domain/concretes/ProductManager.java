package com.ecfcode.hexagonal.domain.concretes;

import com.ecfcode.hexagonal.core.exceptions.BusinessException;
import com.ecfcode.hexagonal.core.utilities.mapping.ModelMapperService;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.core.utilities.results.SuccessDataResult;
import com.ecfcode.hexagonal.core.utilities.results.SuccessResult;
import com.ecfcode.hexagonal.domain.abstracts.ProductService;
import com.ecfcode.hexagonal.domain.models.Product;
import com.ecfcode.hexagonal.domain.requests.products.CreateProductRequest;
import com.ecfcode.hexagonal.domain.requests.products.DeleteProductRequest;
import com.ecfcode.hexagonal.domain.responses.dtos.PageItem;
import com.ecfcode.hexagonal.domain.responses.dtos.PageableResponse;
import com.ecfcode.hexagonal.domain.responses.products.ProductGetResponse;
import com.ecfcode.hexagonal.domain.responses.products.ProductListResponse;
import com.ecfcode.hexagonal.infrastracture.abstracts.ProductRepository;
import com.ecfcode.hexagonal.domain.requests.products.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {

	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {

		checkIfCategoryLimitExceeds(createProductRequest.getCategoryId());
		checkIfProductNameExists(createProductRequest.getProductName());

		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);

		return new SuccessResult("PRODUCT.ADDED");
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		this.productRepository.deleteById(deleteProductRequest.getProductId());
		
		return new SuccessResult("PRODUCT.DELETED");

	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		
		return new SuccessResult("PRODUCT.UPDATED");
	}

	@Override
	public DataResult<ProductGetResponse> getById(int id) {
		Product product = this.productRepository.findById(id);
		ProductGetResponse response = this.modelMapperService.forResponse().map(product,
				ProductGetResponse.class);
		
		return new SuccessDataResult<>(response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> result = this.productRepository.findAll(pageable).getContent();
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ProductListResponse>>(response);
	}
	
	@Override
	public PageableResponse<List<ProductListResponse>> getAllByPage(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> result = this.productRepository.findAll(pageable).getContent();
		Page<Product> resultPage = this.productRepository.findAll(pageable);
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());
		PageItem item = new PageItem();
		item.setPageNo(pageNo);
		item.setPageSize(pageSize);
		item.setTotalPages(resultPage.getTotalPages());
		item.setTotalData(resultPage.getTotalElements());
		
		return new PageableResponse<List<ProductListResponse>>(item,response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAllSortedByAsc(String field) {
		Sort sort = Sort.by(Sort.Order.asc(field));
		List<Product> result = this.productRepository.findAll(sort);
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAllSortedByDesc(String field) {
		Sort sort = Sort.by(Sort.Order.desc(field));
		List<Product> result = this.productRepository.findAll(sort);
		List<ProductListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, ProductListResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ProductListResponse>>(response) ;
	}

	private void checkIfCategoryLimitExceeds(int categoryId) {
		List<Product> result = productRepository.findByCategory_CategoryId(categoryId);
		if (result.size() > 15) {
			throw new BusinessException("NO.MORE.PRODUCTS.CAN.BE.ADDED");
		}
	}
	
	private void checkIfProductNameExists(String name) {
		Product product = this.productRepository.findByProductName(name);
		if (product != null) {
			throw new BusinessException("PRODUCT.NAME.EXISTS");
		}	
	}

}
