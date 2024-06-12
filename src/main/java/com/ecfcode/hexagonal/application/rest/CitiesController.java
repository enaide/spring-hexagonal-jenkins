package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.domain.abstracts.CityService;
import com.ecfcode.hexagonal.domain.requests.cities.CreateCityRequest;
import com.ecfcode.hexagonal.domain.responses.cities.CityListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCityRequest createCityRequest) {
		return this.cityService.add(createCityRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CityListResponse>> getAll(){
		return this.cityService.getAll();
	}

}
