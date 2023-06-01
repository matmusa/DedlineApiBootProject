package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_gen")
    @SequenceGenerator(
            name = "lesson_gen",
            sequenceName = "lesson_seq",
            allocationSize = 1)
    private Long id;
    private String LessonName;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private Course course;
    @OneToMany(mappedBy = "lesson",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    private List<Task>tasks;

}
