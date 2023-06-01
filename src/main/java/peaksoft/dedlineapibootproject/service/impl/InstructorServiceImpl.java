package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.GroupRequest;
import peaksoft.dedlineapibootproject.dto.InstructorRequest;
import peaksoft.dedlineapibootproject.dto.InstructorResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.entity.Instructor;
import peaksoft.dedlineapibootproject.repository.InstructorRepository;
import peaksoft.dedlineapibootproject.service.InstructorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public InstructorResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructor.getFirstName());
        instructor.setLastName(instructor.getLastName());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return new InstructorResponse(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization());
    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        Instructor instructor = new Instructor();
        instructorRepository.findInstructorById(id).orElseThrow(()
                -> new NullPointerException("Instructor with id " + id + "  is not found "));
        return new InstructorResponse(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization());
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }

    @Override
    public InstructorResponse updateInstructorById(Long id, InstructorRequest instructorRequest) {
        Instructor instructor =
                instructorRepository.findInstructorById(id).orElseThrow(()
                        -> new NullPointerException("Instructor with id " + id + "  is not found "));
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return new InstructorResponse(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getSpecialization());
    }

    @Override
    public SimpleResponse deleteInstructorById(Long id) {
        boolean exist = instructorRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Instructor with id: " + id + " is not found");
        }
        instructorRepository.deleteById(id);
        return new SimpleResponse("DELETED","Instructor with id: " + id + " is deleted");

    }
}

