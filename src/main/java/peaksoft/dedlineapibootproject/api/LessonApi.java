package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.service.InstructorService;
import peaksoft.dedlineapibootproject.service.LessonService;

import java.util.List;

    @RestController
    @RequestMapping("/lessons")
    @RequiredArgsConstructor
    public class LessonApi  {
        private final LessonService service;
        @GetMapping
        public List<LessonResponse> getAllLessons() {
            return service.getAllLessons();
        }
        @PostMapping("/save/{courseId}")
        public LessonResponse saveLessons(@PathVariable Long courseId, @RequestBody LessonRequest lessonRequest) {
            return service.saveLesson(courseId,lessonRequest);
        }
        @GetMapping("/{id}")
        public LessonResponse getLessons(@PathVariable Long id){
            return   service.getLessonById(id);
        }
        @PutMapping("/{id}")
        public LessonResponse  updateLessons(@PathVariable Long id,@RequestBody LessonRequest lessonRequest){
            return service.updateLessonById(id,lessonRequest);

        }

        @DeleteMapping("/{id}")
        public SimpleResponse deleteLessonsById(@PathVariable Long id){
            service.deleteLessonById(id);
            return new SimpleResponse("DELETED",  "Lesson with "+id+"  deleted");
        }


    }
