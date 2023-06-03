package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.beans.SimpleBeanInfo;
import java.util.List;

public interface GroupService {
    GroupResponse saveGroup(Long courseId,GroupRequest groupRequest);
    GroupResponse getGroupById(Long id);
    List<GroupResponse> getAllGroups();
    GroupResponse updateGroups(Long id,GroupRequest groupRequest);
    SimpleResponse deleteGroupById(Long id);
    List <GroupResponse>getAllStudentCountFromCourse(Long courseId);

    SimpleResponse assignGroupToCourse(Long courseId,Long groupId);
}
