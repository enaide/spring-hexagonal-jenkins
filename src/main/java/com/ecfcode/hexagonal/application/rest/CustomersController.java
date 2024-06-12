package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.CustomerService;
import com.ecfcode.hexagonal.domain.requests.customers.CreateCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.DeleteCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.UpdateCustomerRequest;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerGetResponse;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteCustomerRequest deleteCustomerRequest) {
    	return this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
    	return this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<CustomerGetResponse> getById(@RequestParam String customerNumber) {
        return this.customerService.getById(customerNumber);
    }
	
	@GetMapping("/getall")
	public DataResult<List<CustomerListResponse>> getAll(){
		return this.customerService.getAll();
	}
}
