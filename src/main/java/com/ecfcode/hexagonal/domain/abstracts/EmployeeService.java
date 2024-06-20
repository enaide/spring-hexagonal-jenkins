package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.employees.CreateEmployeeRequest;
import com.ecfcode.hexagonal.domain.requests.employees.DeleteEmployeeRequest;
import com.ecfcode.hexagonal.domain.requests.employees.UpdateEmployeeRequest;
import com.ecfcode.hexagonal.domain.responses.employees.EmployeeGetResponse;
import com.ecfcode.hexagonal.domain.responses.employees.EmployeeListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {

	Result add(CreateEmployeeRequest createEmployeeRequest);
	Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
	Result update(UpdateEmployeeRequest updateEmployeeRequest);
	
	DataResult<EmployeeGetResponse> getById(Long id);
	DataResult<List<EmployeeListResponse>> getAll();
}
