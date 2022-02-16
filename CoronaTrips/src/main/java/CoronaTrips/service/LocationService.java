package CoronaTrips.service;

import CoronaTrips.domain.Location;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface LocationService {
    Flux<Location> findLocationByCompanyId(Long companyId);

    Flux<Location> findAllLocations();

    Mono<Location> findLocationById(Long id);

    void addNewLocation(Location location, Long companyId);
}
