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
public class CompanyLocationDto {
    @Id
    private long company_id;


    private String company_name;


    private List<Location> locations;

    public CompanyLocationDto(Company company, List<Location> locationList){
        this.company_id = company.getCompanyId();
        this.company_name = company.getCompanyName();
        this.locations = new ArrayList<>();
        this.locations.addAll(locationList);
    }
}
