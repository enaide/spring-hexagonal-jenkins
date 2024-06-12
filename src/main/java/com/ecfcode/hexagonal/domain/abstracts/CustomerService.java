package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.customers.CreateCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.DeleteCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.UpdateCustomerRequest;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerGetResponse;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface CustomerService {

	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	
	DataResult<CustomerGetResponse> getById(String id);
	DataResult<List<CustomerListResponse>> getAll();
}
