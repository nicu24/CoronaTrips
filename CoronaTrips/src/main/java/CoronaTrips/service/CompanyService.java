package CoronaTrips.service;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.dto.CompanyLocationDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CompanyService {
    Flux<Company> findAllCompany();

    Flux<Company> findAllCompanyByLocationId(Long locationId);

    Mono<Company> findCompanyById(Long companyId);

    void findTest();
}
