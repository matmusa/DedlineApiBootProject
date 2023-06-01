package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.GroupResponse;
import peaksoft.dedlineapibootproject.entity.Group;
import peaksoft.dedlineapibootproject.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query("select new peaksoft.dedlineapibootproject.dto.GroupResponse(" +
            "g.id,g.groupName,g.imageLink,g.description)from Group g")
    List<GroupResponse>getAllCompanies();

    Optional<Group>findGroupById(Long id);


}
