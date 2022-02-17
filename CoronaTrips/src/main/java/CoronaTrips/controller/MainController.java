package CoronaTrips.controller;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.CompanyLocationDto;
import CoronaTrips.domain.dto.LocationCompanyDto;
import CoronaTrips.domain.dto.PriceDto;
import CoronaTrips.repository.NativeConnectionRepository;
import CoronaTrips.service.CompanyLocationService;
import CoronaTrips.service.CompanyService;
import CoronaTrips.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final CompanyService companyService;
    private final LocationService locationService;
    private final CompanyLocationService companyLocationService;
    private final NativeConnectionRepository nativeConnectionRepository;

    @GetMapping("getAllCompanyByLocationId/{locationId}")
    public Flux<Company> getAllCompanyByLocationId(@PathVariable(name = "locationId") Long locationId) {
        return companyService.findAllCompanyByLocationId(locationId);
    }


    @GetMapping("getAllCompany")
    public Flux<Company> getAllCompany() {
        return companyService.findAllCompany();
    }

    @GetMapping("getAllCompanyWithLocations")
    public Flux<CompanyLocationDto> getAllCompanyWithLocations() {
        return companyLocationService.findAllCompanyWithLocation();
    }

    @GetMapping("getAllLocations")
    public Flux<Location> getAllLocations() {
        return locationService.findAllLocations();
    }

    @GetMapping("getAllLocationsWithCompanies")
    public Flux<LocationCompanyDto> getAllLocationsWithCompanies() {
        return companyLocationService.findAllLocationsWithCompanies();
    }

    @GetMapping("getLocationById/{locationId}")
    public Mono<Location> getLocationById(@PathVariable(name = "locationId") Long locationId) {
        return locationService.findLocationById(locationId);
    }

    @GetMapping("getAllLocationsByCompanyId/{companyId}")
    public Flux<Location> getAllLocationsByCompanyId(@PathVariable(name = "companyId") Long companyId) {
        return locationService.findLocationByCompanyId(companyId);
    }

    @GetMapping("nativeGetAllCompanies")
    public Flux<Company> nativeFindAllCompanies() {
        return nativeConnectionRepository.nativeFindAll();
    }

    @GetMapping("nativeGetAllCompaniesByLocationId/{locationId}")
    public Flux<Company> nativeFindAllCompanies(@PathVariable(name = "locationId") Long locationId) {
        return nativeConnectionRepository.nativeFindAlCompaniesByLocationId(locationId);
    }


    @GetMapping("nativeGetAllCompaniesWithLocations")
    public Flux<CompanyLocationDto> nativeFindAllCompaniesWithLocations() {
        return nativeConnectionRepository.nativeFindAlCompaniesWithLocations();
    }

    @PostMapping(value = "addLocation/{companyId}", consumes = {"application/json"})
    public Mono<ResponseEntity<String>> createUpdateLocation(@PathVariable(name = "companyId") Long companyId, @RequestBody Location location) {
        return companyService.findCompanyById(companyId)
                .flatMap(s ->
                        locationService.addNewLocation(location,companyId)
                                .then(Mono.just(new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK))).log()
                )
                .defaultIfEmpty(new ResponseEntity<>("Company with id: "+companyId+" Can not be found, error reason:"
                        +HttpStatus.NOT_FOUND.getReasonPhrase(),HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllCompanyLocationsWithPrice")
    public Flux<PriceDto> getAllCompanyLocationsWithPrice() {
    return companyLocationService.findAllCompanyLocationsWithPrice();
    }
}
