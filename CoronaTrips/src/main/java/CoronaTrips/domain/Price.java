package CoronaTrips.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    private int priceId;

    private int companyId;

    private int locationId;

    private float cost;
}
