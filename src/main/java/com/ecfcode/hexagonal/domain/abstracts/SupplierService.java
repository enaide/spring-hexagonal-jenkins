package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.suppliers.CreateSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.DeleteSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.UpdateSupplierRequest;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierGetResponse;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface SupplierService {
	Result add(CreateSupplierRequest createSupplierRequest);
	Result delete(DeleteSupplierRequest deleteSupplierRequest);
	Result update(UpdateSupplierRequest updateSupplierRequest);
	
	DataResult<SupplierGetResponse> getById(int id);
	DataResult<List<SupplierListResponse>> getAll();
}
