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
public class CompanyLocationDto {
    @Id
    private long companyId;

    private String companyName;

    private List<Location> locations;

    public CompanyLocationDto(Company company, List<Location> locationList){
        this.companyId = company.getCompanyId();
        this.companyName = company.getCompanyName();
        this.locations = new ArrayList<>();
        this.locations.addAll(locationList);
    }
}
