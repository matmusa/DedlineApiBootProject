package peaksoft.dedlineapibootproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class InstructorGetAllInformation {
    private Long id;
    private String  firstName;
    private String  lastName;
    private String  specialization;
    private List<String>groupName;
    private int studentCount;
}
