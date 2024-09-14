package portfolio.Models.Samplemflix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {

    private String street;
    private String address;
    private String city;
    private String state;
    private String zipcode;


}
