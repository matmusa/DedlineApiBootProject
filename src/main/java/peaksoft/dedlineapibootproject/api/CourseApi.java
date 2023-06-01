package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.service.CompanyService;

import java.util.List;



    @RestController
    @RequestMapping("/companies")
    @RequiredArgsConstructor
    public class CourseApi {
        private final CompanyService service;

        @GetMapping
        public List<StudentResponce> getAllStudents() {
            return service.getAllStudents();

        }

        @PostMapping("/save")
        public StudentResponce saveStudent(@RequestBody StudentRequest studentRequest) {
            return service.saveStudent(studentRequest);
        }
        @GetMapping("/{id}")
        public StudentResponce getStudentById(@PathVariable Long id){
            return   service.getStudentsById(id);
        }
        @PutMapping("/{id}")
        public Student updateStudent(@PathVariable Long id,@RequestBody  Student student){
            return service.updateStudent(id,student);

        }

        @DeleteMapping("/{id}")
        public String deleteStudentById(@PathVariable Long id){
            service.deleteStudent(id);
            return "Student with "+id+"  deleted";
        }
        @GetMapping("/block")
        public  List<StudentResponce>getAllStudentByBlockedOrUnBlocked(@RequestParam(required = false) boolean isBlocked){
            return service.getAllStudentByBlockerOrNotBlocked(isBlocked);

        }
        @PostMapping
        public SimpleResponse blockUnOrUnBlock(@PathVariable Long id,@RequestParam (required = false) boolean isBlocked){
            return service.blockOrUnBlock(id,isBlocked);
        }


    }

}
