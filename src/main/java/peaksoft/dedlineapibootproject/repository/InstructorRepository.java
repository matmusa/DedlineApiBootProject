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



//
   Optional<Instructor> findInstructorById(Long id);
//
//    @Query("select icg.groupName from " +
//            "Instructor i join i.courses ic " +
//            "join Group.id g join ic.groups icg where g.id=icg.id and i.id=:instructorId  ")
//    List<String> groupName(@Param("instructorId") Long instructorId);
//
//    @Query("select count(s.id)from " +
//            "Instructor i join i.courses ic " +
//            "join Group.id g join ic.groups icg join Student s " +
//            "join s.group sg where sg.id=icg.id and i.id=:instructorId  ")
//    int studentCount(@Param("instructorId") Long instructorId);


  //  @Query("select new peaksoft.dedlineapibootproject.dto.InstructorResponse(i.id, i.firstName, i.id.lastName, i.specialization) from Instructor i where i.id = :id")
  //  Optional<Instructor> findInstructorById(Long id);

    @Query("select new peaksoft.dedlineapibootproject.dto.InstructorResponse(i.id, i.firstName, i.lastName,  i.specialization) from Instructor i")
    List<InstructorResponse> getAllInstructor();

    @Query("select count(s) from Instructor i join i.courses c join  c.groups g join g.students s where i.id=:instructorId")
    int getAllStudentSize(Long instructorId);

    @Query("select g.groupName from Instructor i join i.courses c join  c.groups g where i.id =:instructorId")
    List<String> getAllGroupName(Long instructorId);
}





