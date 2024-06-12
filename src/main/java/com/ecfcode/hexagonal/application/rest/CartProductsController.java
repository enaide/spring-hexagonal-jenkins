package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.CartProductService;
import com.ecfcode.hexagonal.domain.requests.cartproducts.CreateCartProductRequest;
import com.ecfcode.hexagonal.domain.requests.cartproducts.DeleteCartProductRequest;
import com.ecfcode.hexagonal.domain.requests.cartproducts.UpdateCartProductRequest;
import com.ecfcode.hexagonal.domain.responses.cartProducts.CartProductListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cartproducts")
public class CartProductsController {

	private CartProductService cartProductService;

	@Autowired
	public CartProductsController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCartProductRequest createCartProductRequest) {
		return this.cartProductService.add(createCartProductRequest);
	}

	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteCartProductRequest deleteCartProductRequest) {
		return this.cartProductService.delete(deleteCartProductRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCartProductRequest updateCartProductRequest) {
		return this.cartProductService.update(updateCartProductRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<CartProductListResponse> getById(int cartProductId) {
		return this.cartProductService.getById(cartProductId);
	}

	@GetMapping("/getall")
	public DataResult<List<CartProductListResponse>> getAll() {
		return this.cartProductService.getAll();
	}
}
