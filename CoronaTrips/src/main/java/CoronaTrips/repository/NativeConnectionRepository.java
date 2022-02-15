package CoronaTrips.repository;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import CoronaTrips.domain.dto.CompanyLocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;



@Repository
@RequiredArgsConstructor
public class NativeConnectionRepository {

    private final DatabaseClient databaseClient;

//    public static final BiFunction<Row, RowMetadata, Company> MAPPING_FUNCTION = (row, rowMetaData) -> Company.builder()
//            .companyId(row.get("company_id", Long.class))
//            .companyName(row.get("company_name", String.class))
//            .build();

    public Flux<Company> nativeFindAll() {
        return this.databaseClient
                .sql("SELECT * FROM Company")
                .map((row, metadata) -> Company.builder()
                        .companyId(row.get("company_id", Long.class))
                        .companyName(row.get("company_name", String.class))
                        .build()
                )
                .all();
    }

    public Flux<Company> nativeFindAlCompaniesByLocationId(Long locationId) {
        return this.databaseClient
                .sql("SELECT * FROM company join company_location on " +
                        "company.company_id = company_location.company_id where company_location.location_id = " + locationId)
                .map((row, metadata) -> new Company(
                        row.get("company_id", Long.class),
                        row.get("company_name", String.class)
                ))
                .all();
    }

    public Flux<CompanyLocationDto> nativeFindAlCompaniesWithLocations() {
        Flux<Company> allCompanies = this.nativeFindAll();
      return   allCompanies.flatMap(company -> {
            Mono<List<Location>> locations = this.databaseClient.sql("SELECT * from location join company_location on location.location_id = company_location.location_id where company_location.company_id= "+ company.getCompanyId())
                    .map((row,metadata)-> {
                        return new Location(
                                row.get("location_id",Long.class),
                                row.get("location_name",String.class)
                        );
                    }).all().collectList();
            return locations.map(locationList -> new CompanyLocationDto(company,locationList));
        });

    }
}

//               .filter((statement, executeFunction) -> statement.fetchSize(10).execute())
