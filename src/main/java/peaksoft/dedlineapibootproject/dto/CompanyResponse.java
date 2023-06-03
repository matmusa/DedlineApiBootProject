package peaksoft.dedlineapibootproject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.dedlineapibootproject.entity.Instructor;

import java.util.List;

@Getter
@Setter


public class CompanyResponse {
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private List<Instructor>instructors;

    public CompanyResponse(Long id, String name, String country, String address, String phoneNumber, List<Instructor> instructors) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instructors = instructors;
    }

    public CompanyResponse(Long id, String name, String country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }
}