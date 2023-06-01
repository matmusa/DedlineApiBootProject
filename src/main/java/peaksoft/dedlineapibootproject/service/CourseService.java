package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(CourseRequest courseRequest,Long companyLongId);

    CourseResponse getCourseById(Long id);
    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Long id,CourseRequest courseRequest);

    void deleteCourseById(Long id);

}
