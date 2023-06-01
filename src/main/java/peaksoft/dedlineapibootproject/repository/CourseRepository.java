package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
