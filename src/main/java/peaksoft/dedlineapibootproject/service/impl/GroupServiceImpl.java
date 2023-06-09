package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.CourseResponse;
import peaksoft.dedlineapibootproject.dto.GroupRequest;
import peaksoft.dedlineapibootproject.dto.GroupResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.entity.Course;
import peaksoft.dedlineapibootproject.entity.Group;
import peaksoft.dedlineapibootproject.repository.CourseRepository;
import peaksoft.dedlineapibootproject.repository.GroupRepository;
import peaksoft.dedlineapibootproject.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public GroupResponse saveGroup(Long courseId,GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDescription(groupRequest.getDescription());
        group.setImageLink(groupRequest.getImageLink());
        groupRepository.save(group);
        return new GroupResponse(group.getId(),
                group.getGroupName(),
                group.getImageLink(),
                group.getDescription());
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group =
                groupRepository.findGroupById(id).orElseThrow(()
                        -> new NullPointerException("Group with id " + id + "  is not found "));
        return new GroupResponse(
                group.getId(),
                group.getGroupName(),
                group.getImageLink(),
                group.getDescription());

    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.getAllGroup();
    }

    @Override
    public GroupResponse updateGroups(Long id, GroupRequest groupRequest) {
        Group group =
                groupRepository.findGroupById(id).orElseThrow(()
                        -> new NullPointerException("Group with id " + id + "  is not found "));
        group.setGroupName(groupRequest.getGroupName());
        group.setDescription(groupRequest.getDescription());
        group.setImageLink(groupRequest.getImageLink());
        groupRepository.save(group);
        return new GroupResponse(group.getId(),
                group.getGroupName(),
                group.getImageLink(),
                group.getDescription());
    }

    @Override
    public SimpleResponse deleteGroupById(Long id) {
        boolean exist = groupRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Group with id: " + id + " is not found");
        }
        groupRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Group with id: " + id + " is deleted");

    }

    @Override
    public List<GroupResponse> getAllStudentCountFromCourse(Long courseId) {
        return groupRepository.getAllFromGroupStudentCount(courseId);
    }

    @Override
    public SimpleResponse assignGroupToCourse(Long courseId, Long groupId) {
        Course course =
                courseRepository.findCourseById(courseId).orElseThrow(()
                        -> new NullPointerException("Course with id " + courseId + "  is not found "));
        Group group =
                groupRepository.findGroupById(groupId).orElseThrow(()
                        -> new NullPointerException("Group with id " + groupId+ "  is not found "));
         course.getGroups().add(group);
         courseRepository.save(course);
         group.getCourses().add(course);
         courseRepository.save(course);
        return new SimpleResponse(
                "assign","group with id "
                +groupId+" assign to course with id "+courseId);
    }
}

