package CoronaTrips.repository;
import CoronaTrips.domain.Location;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location,Long> {

}
