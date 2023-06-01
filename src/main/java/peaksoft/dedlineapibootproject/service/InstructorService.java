package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.GroupRequest;
import peaksoft.dedlineapibootproject.dto.GroupResponse;
import peaksoft.dedlineapibootproject.dto.InstructorRequest;
import peaksoft.dedlineapibootproject.dto.InstructorResponse;

import java.util.List;

public interface InstructorService {
    InstructorResponse saveInstructor(InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    List<InstructorResponse> getAllInstructors();

    InstructorResponse updateInstructorById(Long id, InstructorRequest instructorRequest);

    void deleteInstructorById(Long id);

}
