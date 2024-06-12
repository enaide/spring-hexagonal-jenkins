package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.countries.CreateCountryRequest;
import com.ecfcode.hexagonal.domain.responses.countries.CountryListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface CountryService {


	Result add(CreateCountryRequest createCountryRequest);
	DataResult<List<CountryListResponse>> getAll();
}
