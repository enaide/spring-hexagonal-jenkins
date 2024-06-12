package com.ecfcode.hexagonal.domain.concretes;

import com.ecfcode.hexagonal.core.utilities.mapping.ModelMapperService;
import com.ecfcode.hexagonal.domain.abstracts.SupplierService;
import com.ecfcode.hexagonal.domain.requests.suppliers.CreateSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.DeleteSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.UpdateSupplierRequest;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierGetResponse;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierListResponse;
import com.ecfcode.hexagonal.infrastracture.abstracts.SupplierRepository;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.core.utilities.results.SuccessDataResult;
import com.ecfcode.hexagonal.core.utilities.results.SuccessResult;
import com.ecfcode.hexagonal.infrastracture.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {

	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {

		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}

	
	@Override
    public Result add(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest()
                .map(createSupplierRequest, Supplier.class);
        this.supplierRepository.save(supplier);
        
        return new SuccessResult("SUPPLIER.ADDED");
    }

    @Override
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
        this.supplierRepository.deleteById(deleteSupplierRequest.getSupplierId());
        
        return new SuccessResult("SUPPLIER.DELETED");

    }

    @Override
    public Result update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest()
                .map(updateSupplierRequest, Supplier.class);
        this.supplierRepository.save(supplier);
        
        return new SuccessResult("SUPPLIER.UPDATED");
    }

    @Override
    public DataResult<SupplierGetResponse> getById(int id) {
        Supplier supplier =this.supplierRepository.findById(id).get();
        SupplierGetResponse response = this.modelMapperService.forResponse()
                .map(supplier, SupplierGetResponse.class);
        
        return new SuccessDataResult<SupplierGetResponse>(response);
    }
	
	@Override
	public DataResult<List<SupplierListResponse>> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = result.stream()
				.map(supplier -> this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<SupplierListResponse>>(response);
	}


}
