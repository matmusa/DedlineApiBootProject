package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.entity.Student;
import peaksoft.dedlineapibootproject.service.LessonService;
import peaksoft.dedlineapibootproject.service.StudentService;

import java.util.List;


    @RestController
    @RequestMapping("/students")
    @RequiredArgsConstructor
    public class StudentApi  {
        private final StudentService service;


        @GetMapping
        public List<StudentResponse> getAllStudents() {
            return service.getAllStudents();

        }

        @PostMapping("/save")
        public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest) {
            return service.saveStudent(studentRequest);
        }
        @GetMapping("/{id}")
        public StudentResponse getStudentById(@PathVariable Long id){
            return service.getStudentById(id);
        }
        @PutMapping("/{id}")
        public StudentResponse updateStudent(@PathVariable Long id,@RequestBody StudentRequest student){
            return service.updateStudentById(id,student);

        }

        @DeleteMapping("/{id}")
        public SimpleResponse deleteStudentById(@PathVariable Long id){
            service.deleteStudentById(id);
            return  new SimpleResponse("Deleted","Student with "+id+"  deleted");
        }
        @GetMapping("/block")
        public  List<StudentResponse>getAllStudentByBlockedOrUnBlocked(@RequestParam(required = false) boolean isBlocked){
            return service.getAllStudentByBlockerOrNotBlocked(isBlocked);

        }
        @PostMapping
        public SimpleResponse blockUnOrUnBlock(
                @PathVariable Long id,
                @RequestParam (required = false)
                boolean isBlocked){
            return service.blockOrUnBlock(id,isBlocked);
        }


    }
