package peaksoft.dedlineapibootproject.dto;


import lombok.Getter;
import lombok.Setter;
import peaksoft.dedlineapibootproject.entity.Instructor;
import peaksoft.dedlineapibootproject.enums.Country;

import javax.security.sasl.SaslClient;
import java.util.List;

@Getter
@Setter


public class CompanyResponse {
    private Long id;
    private String name;
    private Country country;
    private String address;
    private String phoneNumber;


    public CompanyResponse(Long id, String name, Country country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
