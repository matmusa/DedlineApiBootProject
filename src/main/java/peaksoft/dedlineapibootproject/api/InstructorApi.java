package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.service.GroupService;
import peaksoft.dedlineapibootproject.service.InstructorService;

import java.util.List;


    @RestController
    @RequestMapping("/instructors")
    @RequiredArgsConstructor
    public class InstructorApi  {
        private final InstructorService service;


        @GetMapping
        public List<InstructorResponse> getAllInstructors() {
            return service.getAllInstructors();

        }

        @PostMapping("/save")
        public InstructorResponse saveInstructors(@RequestBody InstructorRequest instructorRequest) {
            return service.saveInstructor(instructorRequest);
        }
        @GetMapping("/{id}")
        public InstructorResponse getInstructorById(@PathVariable Long id){
            return   service.getInstructorById(id);
        }
        @PutMapping("/{id}")
        public InstructorResponse  updateInstructor(@PathVariable Long id,@RequestBody InstructorRequest instructorRequest){
            return service.updateInstructorById(id,instructorRequest);

        }

        @DeleteMapping("/{id}")
        public SimpleResponse deleteInstructorById(@PathVariable Long id){
            service.deleteInstructorById(id);
            return new SimpleResponse("DELETED",  "Instructor with "+id+"  deleted");
        }


    }
