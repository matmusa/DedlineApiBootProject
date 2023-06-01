package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.dedlineapibootproject.enums.Gender;
import peaksoft.dedlineapibootproject.enums.StudyFormat;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_gen")
    @SequenceGenerator(
            name = "students_gen",
            sequenceName = "students_seq",
            allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private StudyFormat studyFormat;
    private Gender gender;
    private Boolean isBlocked;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
    CascadeType.DETACH,
    CascadeType.REFRESH})
    private Group group;




























}
