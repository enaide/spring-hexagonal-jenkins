package com.ecfcode.hexagonal.domain.concretes;

import com.ecfcode.hexagonal.domain.abstracts.CustomerService;
import com.ecfcode.hexagonal.domain.requests.customers.CreateCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.DeleteCustomerRequest;
import com.ecfcode.hexagonal.domain.requests.customers.UpdateCustomerRequest;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerGetResponse;
import com.ecfcode.hexagonal.domain.responses.customers.CustomerListResponse;
import com.ecfcode.hexagonal.core.utilities.mapping.ModelMapperService;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.core.utilities.results.SuccessDataResult;
import com.ecfcode.hexagonal.core.utilities.results.SuccessResult;
import com.ecfcode.hexagonal.infrastracture.abstracts.CustomerRepository;
import com.ecfcode.hexagonal.infrastracture.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
		this.customerRepository = customerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		
		return new SuccessResult("CUSTOMER.ADDED");
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		this.customerRepository.deleteById(deleteCustomerRequest.getCustomerNumber());
		
		return new SuccessResult("CUSTOMER.DELETED");
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		
		return new SuccessResult("CUSTOMER.UPDATED");
	}

	@Override
	public DataResult<CustomerGetResponse> getById(String customerId) {
		Customer customer = this.customerRepository.findById(customerId).get();
		CustomerGetResponse response = this.modelMapperService.forRequest().map(customer, CustomerGetResponse.class);
		
		return new SuccessDataResult<CustomerGetResponse>(response);
	}

	@Override
	public DataResult<List<CustomerListResponse>> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = result.stream()
				.map(customer -> this.modelMapperService.forResponse().map(customer, CustomerListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<CustomerListResponse>>(response) ;
	}

}
