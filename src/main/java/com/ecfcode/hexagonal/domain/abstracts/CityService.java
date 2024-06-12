package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.cities.CreateCityRequest;
import com.ecfcode.hexagonal.domain.responses.cities.CityListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface CityService {

	Result add(CreateCityRequest createCityRequest);
	DataResult<List<CityListResponse>> getAll();
	
}
