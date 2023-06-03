package peaksoft.dedlineapibootproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupRequest {
    private String groupName;
    private String imageLink;
    private String description;

    public GroupRequest(String groupName) {
        this.groupName = groupName;
    }
}
