package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



    @Entity
    @Table(name = "companies")
    @Getter
    @Setter
    @NoArgsConstructor
    public class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_gen")
        @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)

        private Long id;
        private String name;
        private String country;
        private String address;
        private String phoneNumber;
        @OneToMany(mappedBy = "company",cascade =
                {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.REFRESH })
        private List<Course> courses;
        @ManyToMany(mappedBy = "companies",cascade =
                {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                CascadeType.REMOVE})
        private List<Instructor>instructors;

    }
