package CoronaTrips.controller;
import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.domain.dto.LocationCompanyDto;
import CoronaTrips.repository.NativeConnectionRepository;
import CoronaTrips.service.CompanyLocationService;
import CoronaTrips.service.CompanyService;
import CoronaTrips.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final CompanyService companyService;
    private final LocationService locationService;
    private final CompanyLocationService companyLocationService;
    private final NativeConnectionRepository nativeConnectionRepository;

    @GetMapping("getAllCompanyByLocationId/{locationId}")
    public Flux<Company> getAllCompanyByLocationId(@PathVariable(name = "locationId") Long locationId){
        return companyService.findAllCompanyByLocationId(locationId);
    }


    @GetMapping("getAllCompany")
    public Flux<Company>getAllCompany(){
        return companyService.findAllCompany();
    }
    @GetMapping("getAllCompanyWithLocations")
    public Flux<CompanyLocationDto>getAllCompanyWithLocations(){
        return companyLocationService.findAllCompanyWithLocation();
    }

    @GetMapping("getAllLocations")
    public Flux<Location>getAllLocations(){
        return locationService.findAllLocations();
    }

    @GetMapping("getLocationById/{locationId}")
    public Mono<Location> getLocationById(@PathVariable( name = "locationId") Long locationId){
        return locationService.findLocationById(locationId);
    }

    @GetMapping("getAllLocationsByCompanyId/{companyId}")
    public Flux<Location>getAllLocationsByCompanyId(@PathVariable(name = "companyId") Long companyId){
        return locationService.findLocationByCompanyId(companyId);
    }

    @GetMapping("getAllLocationsWithCompanies")
    public Flux<LocationCompanyDto>getAllLocationsByCompanyId(){
        return companyLocationService.findAllLocationsWithCompanies();
    }

    @GetMapping("nativeGetAllCompanies")
    public Flux<Company> nativeFindAllCompanies(){
        return nativeConnectionRepository.nativeFindAll();
    }


    @GetMapping("t")
    public void test(){

    }
}
