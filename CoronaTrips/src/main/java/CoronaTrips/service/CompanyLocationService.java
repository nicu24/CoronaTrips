package CoronaTrips.service;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.domain.dto.LocationCompanyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Flux;


public interface CompanyLocationService {
    public Flux<LocationCompanyDto> findAllLocationsWithCompanies();
    public Flux<CompanyLocationDto> findAllCompanyWithLocation();
}
