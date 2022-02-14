package CoronaTrips.repository;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.CompanyLocation;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CompanyLocationRepository extends ReactiveCrudRepository<CompanyLocation,Long> {
    @Query("SELECT * FROM company_location WHERE location_id = :locationId")
    Flux<CompanyLocation> findCompanyLocationByLocationId(Long locationId);

    @Query("SELECT * FROM company_location WHERE company_id = :companyId")
    Flux<CompanyLocation> findCompanyLocationByCompanyId(Long companyId);
}
