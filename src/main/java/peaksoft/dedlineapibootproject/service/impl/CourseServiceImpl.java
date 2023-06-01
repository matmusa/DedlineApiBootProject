package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.CompanyResponse;
import peaksoft.dedlineapibootproject.dto.CourseRequest;
import peaksoft.dedlineapibootproject.dto.CourseResponse;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.entity.Company;
import peaksoft.dedlineapibootproject.entity.Course;
import peaksoft.dedlineapibootproject.repository.CompanyRepository;
import peaksoft.dedlineapibootproject.repository.CourseRepository;
import peaksoft.dedlineapibootproject.service.CourseService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Override
    public CourseResponse saveCourse(CourseRequest courseRequest, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        course.setCompany(company);
        courseRepository.save(course);
        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getDateOfStart(),
                course.getDescription());

    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course =
        courseRepository.findCourseById(id).orElseThrow(()
                -> new NullPointerException("Course with id " + id + "  is not found "));
        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getDateOfStart(),
                course.getDescription());

    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = new Course();
        courseRepository.findCourseById(id).orElseThrow(()
                -> new NullPointerException("Course with id " + id + "  is not found "));
        course.setCourseName(courseRequest.getCourseName());
        course.setDateOfStart(courseRequest.getDateOfStart());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getDateOfStart(),
                course.getDescription());
    }

    @Override
    public SimpleResponse deleteCourseById(Long id) {
        boolean exist = courseRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Course with id: " + id + " is not found");
        }
        courseRepository.deleteById(id);
        return new SimpleResponse("DELETED","Course with id: " + id + " is deleted");

    }
    }

