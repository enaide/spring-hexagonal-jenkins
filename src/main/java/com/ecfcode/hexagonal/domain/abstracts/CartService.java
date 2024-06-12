package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.requests.carts.CreateCartRequest;
import com.ecfcode.hexagonal.domain.requests.carts.DeleteCartRequest;
import com.ecfcode.hexagonal.domain.requests.carts.UpdateCartRequest;
import com.ecfcode.hexagonal.domain.responses.carts.CartListResponse;

import java.util.List;

public interface CartService {

	Result add (CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    DataResult<CartListResponse> getById(int cartId);
	DataResult<List<CartListResponse>> getAll();
	
	
}
