package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.service.TaskService;

import java.util.List;

    @RestController
    @RequestMapping("/tasks")
    @RequiredArgsConstructor
    public class TaskApi  {
        private final TaskService service;


        @GetMapping
        public List<TaskResponse> getAllTasks() {
            return service.getAllTask();

        }

        @PostMapping("/save/{lessonId}")
        public TaskResponse saveTasks(@PathVariable Long lessonId, @RequestBody TaskRequest taskRequest) {
            return service.saveTask(lessonId,taskRequest);
        }
        @GetMapping("/{id}")
        public TaskResponse getTaskById(@PathVariable Long id){

            return   service.getTaskById(id);
        }
        @PutMapping("/{id}")
        public TaskResponse  updateTask(@PathVariable Long id,@RequestBody TaskRequest taskRequest){
            return service.updateTaskById(id,taskRequest);

        }

        @DeleteMapping("/{id}")
        public SimpleResponse deleteTaskById(@PathVariable Long id){
            service.deleteTaskById(id);
            return new SimpleResponse("DELETED",  "Task with "+id+"  deleted");
        }

    }
