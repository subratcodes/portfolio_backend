package portfolio.Models.Samplemflix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Location {

    private Address address;
    private Geo geo;

}
