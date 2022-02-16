package CoronaTrips.repository;
import CoronaTrips.domain.Location;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location,Long> {
    @Query("Select * from location join company_location on location.location_id = company_location.location_id where company_location.company_id = :companyId")
    Flux<Location> findAllLoacationsByCompanyId(Long companyId);

    @Query("INSERT INTO company_location (company_id,location_id) VALUES(:companyId,:locationId);")
    Mono<Location> addForeignKey(Long locationId, Long companyId);
}
