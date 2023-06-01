package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.dto.StudentRequest;
import peaksoft.dedlineapibootproject.dto.StudentResponse;
import peaksoft.dedlineapibootproject.repository.StudentRepository;
import peaksoft.dedlineapibootproject.service.StudentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return null;
    }

    @Override
    public StudentResponse updateStudentById(Long id, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {
    }

    @Override
    public List<StudentResponse> getAllStudentByBlockerOrNotBlocked(boolean isBlocked) {
        return null;
    }

    @Override
    public SimpleResponse blockOrUnBlock(Long id, Boolean isBlocked) {
        return null;
    }

}
