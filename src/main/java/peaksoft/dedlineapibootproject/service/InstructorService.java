package peaksoft.dedlineapibootproject.service;

import jdk.dynalink.linker.support.SimpleLinkRequest;
import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface InstructorService {
    InstructorResponse saveInstructor(InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    List<InstructorResponse> getAllInstructors();

    InstructorResponse updateInstructorById(Long id, InstructorRequest instructorRequest);
    InstructorGetAllInformation  getAllInformationInstructorById(Long id);
    SimpleResponse assignInstructorToCompany(Long companyId, Long instructorId);


    SimpleResponse deleteInstructorById(Long id);


}
