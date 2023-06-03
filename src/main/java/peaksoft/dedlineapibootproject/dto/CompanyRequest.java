package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.dedlineapibootproject.entity.Instructor;

import java.util.List;

@Getter
@Setter

public class CompanyRequest {
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private List<Instructor>instructors;

    public CompanyRequest(String name, String country, String address, String phoneNumber, List<Instructor> instructors) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instructors = instructors;
    }

    public CompanyRequest(String name, String country, String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
