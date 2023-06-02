package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(CourseRequest courseRequest,Long companyLongId,Long courseId);

    CourseResponse getCourseById(Long id);
    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Long id,CourseRequest courseRequest);

    SimpleResponse deleteCourseById(Long id);

}
