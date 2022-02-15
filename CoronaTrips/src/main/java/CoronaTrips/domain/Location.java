package CoronaTrips.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private  long locationId;

    private String locationName;

}
