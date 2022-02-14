package CoronaTrips.service.Impl;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.CompanyLocation;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.LocationCompanyDto;
import CoronaTrips.repository.CompanyLocationRepository;
import CoronaTrips.repository.LocationRepository;
import CoronaTrips.service.CompanyService;
import CoronaTrips.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final CompanyLocationRepository companyLocationRepository;

    @Override
    public Flux<Location> findLocationByCompanyId(Long companyId) {
       return companyLocationRepository.findCompanyLocationByCompanyId(companyId)
               .map(CompanyLocation::getLocation_id).collectList().flatMapMany(locationRepository::findAllById);
    }

    @Override
    public Flux<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Mono<Location> findLocationById(Long id) {
        return locationRepository.findById(id);
    }




}
