package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.LessonResponse;
import peaksoft.dedlineapibootproject.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    @Query("select new peaksoft.dedlineapibootproject.dto.LessonResponse(l.id,l.LessonName)from Lesson l")
    List<LessonResponse>getAllLessons();

    Optional<LessonResponse>findLessonById(Long id);

}
