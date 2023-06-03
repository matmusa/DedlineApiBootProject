package peaksoft.dedlineapibootproject.dto;

import lombok.*;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorGetAllInformation {
    private Long id;
    private String  firstName;
    private String  lastName;
    private String  specialization;
    private List<String>groupName;
    private int studentCount;
}
