package CoronaTrips.service;


import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.domain.dto.LocationCompanyDto;
import CoronaTrips.domain.dto.PriceDto;
import reactor.core.publisher.Flux;


public interface CompanyLocationService {
    Flux<LocationCompanyDto> findAllLocationsWithCompanies();
    Flux<CompanyLocationDto> findAllCompanyWithLocation();
    Flux<PriceDto> findAllCompanyLocationsWithPrice();
}
