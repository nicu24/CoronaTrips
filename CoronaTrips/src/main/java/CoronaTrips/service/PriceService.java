package CoronaTrips.service;

import CoronaTrips.domain.Price;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PriceService {
    Flux<Price> getAllPrices();
    Mono<Price> getPriceByCompanyIdAndLocationId(long companyId, long locationId);
    Mono<Price> getPriceById(long priceId);
}
