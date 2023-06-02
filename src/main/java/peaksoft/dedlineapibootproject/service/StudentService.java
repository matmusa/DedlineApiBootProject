package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(Long id);
    List<StudentResponse> getAllStudents();
    StudentResponse updateStudentById(Long id,StudentRequest studentRequest);
    SimpleResponse deleteStudentById(Long id);
    List<StudentResponse> getAllStudentByBlockerOrNotBlocked(boolean isBlocked);
    SimpleResponse blockOrUnBlock(Long id, Boolean isBlocked);

    SimpleResponse assignStudentToGroup(Long groupId,Long studentId);
}
