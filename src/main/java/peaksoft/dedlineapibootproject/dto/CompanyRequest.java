package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import peaksoft.dedlineapibootproject.entity.Instructor;
import peaksoft.dedlineapibootproject.enums.Country;

import java.util.List;

@Getter
@Setter

public class CompanyRequest {
    private String name;
    private Country country;
    private String address;
    @Pattern("\\+996\\{9}")
    private String phoneNumber;


    public CompanyRequest(String name, Country country, String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
