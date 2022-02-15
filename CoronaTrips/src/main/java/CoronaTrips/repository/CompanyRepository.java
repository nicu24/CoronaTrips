package CoronaTrips.repository;

import CoronaTrips.domain.Company;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends ReactiveCrudRepository<Company,Long> {

}
