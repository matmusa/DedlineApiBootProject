package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.dto.StudentRequest;
import peaksoft.dedlineapibootproject.dto.StudentResponse;
import peaksoft.dedlineapibootproject.entity.Group;
import peaksoft.dedlineapibootproject.entity.Student;
import peaksoft.dedlineapibootproject.repository.GroupRepository;
import peaksoft.dedlineapibootproject.repository.StudentRepository;
import peaksoft.dedlineapibootproject.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setIsBlocked(false);
        studentRepository.save(student);
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStudyFormat(),
                student.getGender());
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = new Student();
        studentRepository.findStudentById(id)
                .orElseThrow(() -> new NullPointerException("Lesson with id " + id + "  is not found "));
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStudyFormat(),
                student.getGender());

    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public StudentResponse updateStudentById(Long id, StudentRequest studentRequest) {
        Student student =
                studentRepository.findStudentById(id)
                        .orElseThrow(() -> new NullPointerException("Lesson with id " + id + "  is not found "));
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student.setStudyFormat(studentRequest.getStudyFormat());
        studentRepository.save(student);
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStudyFormat(),
                student.getGender());
    }

    @Override
    public SimpleResponse deleteStudentById(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        studentRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Student with id: " + id + " is deleted");

    }


    @Override
    public List<StudentResponse> getAllStudentByBlockerOrNotBlocked(boolean isBlocked) {
        return studentRepository.findStudentByIsBlocked(isBlocked);
    }

    @Override
    public SimpleResponse blockOrUnBlock(Long id, Boolean isBlocked) {
        try {
            Student student1 = studentRepository.findById(id)
                    .orElseThrow(() ->
                            new NullPointerException("User with id " + id + "  is not found "));
            student1.setIsBlocked(isBlocked);
            studentRepository.save(student1);
            return new SimpleResponse("Blocked", "students with " + id + "  is blocked");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return null;


    }

    @Override
    public SimpleResponse  assignStudentToGroup(Long groupId, Long studentId) {
        Group group =
                groupRepository.findGroupById(groupId).orElseThrow(()
                        -> new NullPointerException("Group with id " + groupId + "  is not found "));
        Student student =
                studentRepository.findStudentById(studentId)
                        .orElseThrow(() -> new NullPointerException("Lesson with id " + studentId + "  is not found "));
        group.getStudents().add(student);
        groupRepository.save(group);
        student.setGroup(group);
        studentRepository.save(student);
        return new SimpleResponse(
                "assign","student with id "
                +studentId+" assign to group with id "+groupId);    }
}
