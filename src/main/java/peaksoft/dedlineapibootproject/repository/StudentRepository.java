package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.StudentResponse;
import peaksoft.dedlineapibootproject.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {



    @Query("select new peaksoft.dedlineapibootproject.dto.StudentResponse" +
            "(s.id,s.firstName,s.lastName,s.phoneNumber,s.email)from Student s")
    List<StudentResponse> getAllStudents();

    Optional<StudentResponse> findStudentById(Long id);









































}
