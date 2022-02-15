package CoronaTrips.service.Impl;

import CoronaTrips.domain.CompanyLocation;
import CoronaTrips.domain.Location;
import CoronaTrips.repository.LocationRepository;
import CoronaTrips.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Flux<Location> findLocationByCompanyId(Long companyId) {
       return locationRepository.findAllLoacationsByCompanyId(companyId);
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
