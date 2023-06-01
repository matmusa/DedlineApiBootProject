package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
