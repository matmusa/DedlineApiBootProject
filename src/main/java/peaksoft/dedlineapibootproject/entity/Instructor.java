package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy =
            GenerationType.SEQUENCE,
            generator = "instructor_gen")
    @SequenceGenerator(
            name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)

    private Long id;
    private String  firstName;
    private String  lastName;
    private String  specialization;
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Company>companies;
    @OneToMany(mappedBy = "instructor",cascade = {
           CascadeType.ALL})
    private List<Course>courses;

}
