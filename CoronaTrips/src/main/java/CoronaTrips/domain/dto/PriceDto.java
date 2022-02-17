package CoronaTrips.domain.dto;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {
    private long priceId;

    private Company company;

    private Location location;

    private float cost;
}
