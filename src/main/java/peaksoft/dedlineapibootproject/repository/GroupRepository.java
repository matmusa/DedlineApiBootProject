package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.dedlineapibootproject.dto.GroupResponse;
import peaksoft.dedlineapibootproject.entity.Group;
import peaksoft.dedlineapibootproject.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query("select new peaksoft.dedlineapibootproject.dto.GroupResponse(" +
            "g.id,g.groupName,g.imageLink,g.description)from Group g")
    List<GroupResponse>getAllGroup();

    @Query("select new peaksoft.dedlineapibootproject.dto" +
            ".GroupResponse(g.groupName,COUNT(s.id)) " +
            "from Group g JOIN" +
            " g.students gs JOIN " +
            "Student s where gs.id=s.id" +
            " and g.id=:courseId group by g "  )
    List<GroupResponse>getAllFromGroupStudentCount(@Param("courseId") Long courseId);

    Optional<Group>findGroupById(Long id);


}
