package CoronaTrips.repository;

import CoronaTrips.domain.Price;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Price,Long> {

    @Query("Select * from price where company_id=:companyId and location_id=:priceId")
    Mono<Price> getPriceByCompanyIdAndLocationId(long companyId, long priceId);
}
