package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.CartService;
import com.ecfcode.hexagonal.domain.requests.carts.CreateCartRequest;
import com.ecfcode.hexagonal.domain.requests.carts.DeleteCartRequest;
import com.ecfcode.hexagonal.domain.requests.carts.UpdateCartRequest;
import com.ecfcode.hexagonal.domain.responses.carts.CartListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCartRequest createCartRequest){
		return this.cartService.add(createCartRequest);
	}
	@PostMapping("/delete")
	public Result delete(@Valid  @RequestBody DeleteCartRequest deleteCartRequest){
		return this.cartService.delete(deleteCartRequest);
	}
	
	@PostMapping("/update")
	public Result update (@Valid @RequestBody UpdateCartRequest updateCartRequest){
		return this.cartService.update(updateCartRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartListResponse> getById(int cartId){
		return this.cartService.getById(cartId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartListResponse>> getAll(){
		return this.cartService.getAll();
	}
	


}
