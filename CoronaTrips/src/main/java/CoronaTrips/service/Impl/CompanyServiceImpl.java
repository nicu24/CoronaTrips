package CoronaTrips.service.Impl;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.CompanyLocation;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.repository.CompanyLocationRepository;
import CoronaTrips.repository.CompanyRepository;
import CoronaTrips.repository.LocationRepository;
import CoronaTrips.service.CompanyService;
import CoronaTrips.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyLocationRepository companyLocationRepository;

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
        Flux<Company> companyFlux =  companyLocationRepository.findCompanyLocationByLocationId(companyId)
                .map(CompanyLocation::getCompany_id).collectList()
                .flatMapMany(companyRepository::findAllById);
        return companyFlux;
    }

    @Override
    public void findTest() {
    }
}
