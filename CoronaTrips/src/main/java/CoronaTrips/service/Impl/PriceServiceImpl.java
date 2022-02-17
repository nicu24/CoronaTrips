package CoronaTrips.service.Impl;

import CoronaTrips.domain.Price;
import CoronaTrips.repository.PriceRepository;
import CoronaTrips.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public Flux<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public Mono<Price> getPriceByCompanyIdAndLocationId(long companyId, long locationId) {
        return priceRepository.getPriceByCompanyIdAndLocationId(companyId,locationId);
    }

    @Override
    public Mono<Price> getPriceById(long priceId) {
        return priceRepository.findById(priceId);
    }
}
