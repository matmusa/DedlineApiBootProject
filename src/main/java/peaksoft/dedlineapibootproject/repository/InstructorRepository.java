package peaksoft.dedlineapibootproject.repository;

import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import peaksoft.dedlineapibootproject.dto.InstructorResponse;
import peaksoft.dedlineapibootproject.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {



    @Query("select new peaksoft.dedlineapibootproject.dto.InstructorResponse" +
            "(i.id,i.firstName,i.lastName,i.specialization)from Instructor i")
    List<InstructorResponse> getAllInstructors();

    Optional<Instructor> findInstructorById(Long id);



}
