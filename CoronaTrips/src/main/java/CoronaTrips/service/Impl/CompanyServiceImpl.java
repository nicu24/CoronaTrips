package CoronaTrips.service.Impl;

import CoronaTrips.domain.Company;
import CoronaTrips.repository.CompanyRepository;
import CoronaTrips.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Flux<Company> findAllCompany() {
       return companyRepository.findAll();
    }

    @Override
    public Mono<Company> findCompanyById(Long companyId) {
        return companyRepository.findById(companyId);

    }

    @Override
    public Flux<Company> findAllCompanyByLocationId(Long companyId) {
        return companyRepository.findCompaniesByLocationId(companyId);
    }

    @Override
    public void findTest() {
    }
}
