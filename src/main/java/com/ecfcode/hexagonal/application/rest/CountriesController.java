package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.CountryService;
import com.ecfcode.hexagonal.domain.requests.countries.CreateCountryRequest;
import com.ecfcode.hexagonal.domain.responses.countries.CountryListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountriesController {
	
	private CountryService countryService;

	@Autowired
	public CountriesController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCountryRequest createCountryRequest) {
		return this.countryService.add(createCountryRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CountryListResponse>>getAll(){
		return this.countryService.getAll();
	}

}
