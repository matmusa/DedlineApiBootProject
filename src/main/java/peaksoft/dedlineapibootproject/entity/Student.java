package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Value;
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
    @Pattern("\\+996\\{9}")
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "study_format", columnDefinition = "VARCHAR(255)")
    private StudyFormat studyFormat;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Boolean isBlocked;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
    CascadeType.DETACH,
    CascadeType.REFRESH})
    private Group group;




























}
