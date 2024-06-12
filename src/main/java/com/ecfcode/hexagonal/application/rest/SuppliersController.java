package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.SupplierService;
import com.ecfcode.hexagonal.domain.requests.suppliers.CreateSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.DeleteSupplierRequest;
import com.ecfcode.hexagonal.domain.requests.suppliers.UpdateSupplierRequest;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierGetResponse;
import com.ecfcode.hexagonal.domain.responses.suppliers.SupplierListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@PostMapping("/add")
    public Result add(@Valid @RequestBody CreateSupplierRequest createSupplierRequest) {
		return this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public Result delete(@Valid @RequestBody DeleteSupplierRequest deleteSupplierRequest) {
    	return this.supplierService.delete(deleteSupplierRequest);
    }

    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<SupplierGetResponse> getById(@RequestParam int id) {
        return this.supplierService.getById(id);
    }
	@GetMapping("/getall")
	public DataResult<List<SupplierListResponse>> getAll(){
		return this.supplierService.getAll();
	}
}
