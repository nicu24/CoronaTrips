package CoronaTrips.service.Impl;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.Price;
import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.domain.dto.LocationCompanyDto;
import CoronaTrips.domain.dto.PriceDto;
import CoronaTrips.service.CompanyLocationService;
import CoronaTrips.service.CompanyService;
import CoronaTrips.service.LocationService;
import CoronaTrips.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyLocationServiceImpl implements CompanyLocationService {
    private final CompanyService companyService;
    private final LocationService locationService;
    private final PriceService priceService;


    @Override
    public Flux<LocationCompanyDto> findAllLocationsWithCompanies() {
        return this.locationService.findAllLocations().flatMap(location->{
            Mono<List<Company>> companies = this.companyService.findAllCompanyByLocationId(location.getLocationId()).collectList();
            return companies.map(companyList -> new LocationCompanyDto(location,companyList));
        });
    }

    @Override
    public Flux<CompanyLocationDto> findAllCompanyWithLocation() {
        return companyService.findAllCompany().flatMap(company -> {
            Mono<List<Location>> listMono = locationService.findLocationByCompanyId(company.getCompanyId()).collectList();
            return listMono.map(locations-> new CompanyLocationDto(company,locations));
        });
    }

    @Override
    public Flux<PriceDto> findAllCompanyLocationsWithPrice() {
        Flux<Price> price = priceService.getAllPrices();
       return price.flatMap(k-> Flux.zip(companyService.findCompanyById((long) k.getCompanyId()),locationService.findLocationById((long) k.getLocationId()),
               (first, second)
               -> new PriceDto(k.getPriceId(),first,second,k.getCost()))).log();

    }
}
