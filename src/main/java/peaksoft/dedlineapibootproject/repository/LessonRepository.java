package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

}
