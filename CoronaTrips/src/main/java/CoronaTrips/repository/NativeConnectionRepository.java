package CoronaTrips.repository;

import CoronaTrips.domain.Company;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.function.BiFunction;


@Repository
@RequiredArgsConstructor
public class NativeConnectionRepository {

    private final DatabaseClient databaseClient;

    public static final BiFunction<Row, RowMetadata, Company> MAPPING_FUNCTION = (row, rowMetaData) -> Company.builder()
            .company_id(row.get("company_id", Long.class))
            .company_name(row.get("company_name", String.class))
            .build();

    public Flux<Company> nativeFindAll() {
        return this.databaseClient
                .sql("SELECT * FROM Company")
                .filter((statement, executeFunction) -> statement.fetchSize(10).execute())
                .map((row,metadata) -> Company.builder()
                        .company_id(row.get("company_id", Long.class))
                        .company_name(row.get("company_name", String.class))
                        .build()
                )
                .all();
    }
}
