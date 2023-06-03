package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.CourseResponse;
import peaksoft.dedlineapibootproject.entity.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {


    @Query("select new peaksoft.dedlineapibootproject.dto.CourseResponse" +
            "(c.id,c.courseName,c.description)from Course c order by c.dateOfStart")
    List<CourseResponse>getAllCourses();
    Optional<Course>findCourseById(Long id);

}
