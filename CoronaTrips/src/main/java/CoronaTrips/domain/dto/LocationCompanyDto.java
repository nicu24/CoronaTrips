package CoronaTrips.domain.dto;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationCompanyDto {
    @Id
    private long locationId;

    private String locationName;

    private List<Company> companies = new ArrayList<>();

    public LocationCompanyDto(Location location, List<Company> companies){
        this.locationId = location.getLocationId();
        this.locationName = location.getLocationName();
        this.companies.addAll(companies);
    }
}
