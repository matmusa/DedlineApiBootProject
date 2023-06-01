package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.service.CompanyService;
import peaksoft.dedlineapibootproject.service.CourseService;

import java.util.List;


    @RestController
    @RequestMapping("/courses")
    @RequiredArgsConstructor
    public class CourseApi  {
        private final CourseService service;


        @GetMapping
        public List<CourseResponse> getAllCourses() {
            return service.getAllCourses();

        }
        @PostMapping("/save")
        public CourseResponse saveCourses(@RequestBody CourseRequest courseRequest,@PathVariable Long id) {
            return service.saveCourse(courseRequest,id);
        }
        @GetMapping("/{id}")
        public CourseResponse getCoursesById(@PathVariable Long id){
            return   service.getCourseById(id);
        }
        @PutMapping("/{id}")
        public CourseResponse  updateCourses(@PathVariable Long id,@RequestBody CourseRequest courseRequest){
            return service.updateCourse(id,courseRequest);

        }
        @DeleteMapping("/{id}")
        public SimpleResponse deleteCourseById(@PathVariable Long id){
            service.deleteCourseById(id);
            return new SimpleResponse("DELETED",  "Course with "+id+"  deleted");
        }

    }
