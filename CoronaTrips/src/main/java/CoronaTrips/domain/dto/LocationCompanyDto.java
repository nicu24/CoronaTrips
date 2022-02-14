package CoronaTrips.domain.dto;

import CoronaTrips.domain.Company;
import CoronaTrips.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationCompanyDto {
    @Id
    private long location_id;

    private String location_name;

    private List<Company> companies = new ArrayList<>();

    public LocationCompanyDto(Location location, List<Company> companies){
        this.location_id = location.getLocation_id();
        this.location_name = location.getLocation_name();
        this.companies.addAll(companies);
    }
}
