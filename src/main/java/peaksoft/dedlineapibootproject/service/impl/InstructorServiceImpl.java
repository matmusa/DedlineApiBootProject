package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.entity.Company;
import peaksoft.dedlineapibootproject.entity.Instructor;
import peaksoft.dedlineapibootproject.repository.CompanyRepository;
import peaksoft.dedlineapibootproject.repository.InstructorRepository;
import peaksoft.dedlineapibootproject.service.InstructorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;

    @Override
    public InstructorResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
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
        return instructorRepository.getAllInstructor();
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
    public InstructorGetAllInformation getAllInformationInstructorById(Long id) {
        Instructor instructor =
                instructorRepository.findInstructorById(id).orElseThrow(()
                        -> new NullPointerException("Instructor with id " + id + "  is not found "));
        return InstructorGetAllInformation.builder()
                .id(instructor.getId())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .specialization(instructor.getSpecialization())
                .groupName(instructorRepository.getAllGroupName(id))
                .studentCount(instructorRepository.getAllStudentSize(id))
                .build();

    }

    @Override
    public SimpleResponse assignInstructorToCompany(Long companyId, Long instructorId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new NullPointerException("User with id " + companyId + "  is not found "));
        Instructor instructor =
                instructorRepository.findInstructorById(instructorId).orElseThrow(()
                        -> new NullPointerException("Instructor with id " + instructorId + "  is not found "));
        company.getInstructors().add(instructor);
        companyRepository.save(company);
        instructorRepository.save(instructor);
        instructor.getCompanies().add(company);
        return new SimpleResponse(
                "assign","instructor with id "
                +instructorId+" assign to company with id "+companyId);
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

