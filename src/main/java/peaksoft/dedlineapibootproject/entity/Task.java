package peaksoft.dedlineapibootproject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_gen")
    @SequenceGenerator(
            name = "task_gen",
            sequenceName = "task_seq",
            allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate deadline;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Lesson lesson;

}
