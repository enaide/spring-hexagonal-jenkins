package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.cartproducts.CreateCartProductRequest;
import com.ecfcode.hexagonal.domain.requests.cartproducts.DeleteCartProductRequest;
import com.ecfcode.hexagonal.domain.requests.cartproducts.UpdateCartProductRequest;
import com.ecfcode.hexagonal.domain.responses.cartProducts.CartProductListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface CartProductService {

	Result add(CreateCartProductRequest createCartProductRequest);
	Result update(UpdateCartProductRequest updateCartProductRequest);
	Result delete(DeleteCartProductRequest deleteCartProductRequest);
	DataResult<List<CartProductListResponse>> getAll();
	DataResult<CartProductListResponse> getById(int cartProductId);
}
