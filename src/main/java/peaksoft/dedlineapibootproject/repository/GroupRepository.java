package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Group;
import peaksoft.dedlineapibootproject.entity.Instructor;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
