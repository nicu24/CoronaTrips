package CoronaTrips.repository;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.CompanyLocation;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface CompanyRepository extends ReactiveCrudRepository<Company,Long> {
    @Query("SELECT * FROM company join company_location on company.company_id = company_location.company_id where company_location.location_id = :locationId")
    Flux<Company> findCompaniesByLocationId(Long locationId);
}
