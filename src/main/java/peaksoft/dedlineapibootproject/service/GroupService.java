package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.CompanyRequest;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.GroupRequest;
import peaksoft.dedlineapibootproject.dto.GroupResponse;

import java.util.List;

public interface GroupService {
    GroupResponse saveGroup(GroupRequest groupRequest);
    GroupResponse getGroupById(Long id);
    List<GroupResponse> getAllGroups();
    GroupResponse updateGroups(Long id,GroupRequest groupRequest);
    void deleteGroupById(Long id);
}
