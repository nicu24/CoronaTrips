package CoronaTrips.repository;


import CoronaTrips.domain.Company;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.sql.Join;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CompanyRepository extends ReactiveCrudRepository<Company,Long> {

}
