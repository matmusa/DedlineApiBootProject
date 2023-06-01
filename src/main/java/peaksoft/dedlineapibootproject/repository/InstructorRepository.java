package peaksoft.dedlineapibootproject.repository;

import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import peaksoft.dedlineapibootproject.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
