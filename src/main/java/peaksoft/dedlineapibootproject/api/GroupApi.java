package peaksoft.dedlineapibootproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dedlineapibootproject.dto.*;
import peaksoft.dedlineapibootproject.service.CourseService;
import peaksoft.dedlineapibootproject.service.GroupService;

import java.util.List;


    @RestController
    @RequestMapping("/groups")
    @RequiredArgsConstructor
    public class GroupApi  {
        private final GroupService service;


        @GetMapping
        public List<GroupResponse> getAllGroup() {
            return service.getAllGroups();

        }

        @PostMapping("/save/{courseId}")
        public GroupResponse saveGroup(@PathVariable Long courseId,@RequestBody GroupRequest groupRequest) {
            return service.saveGroup(courseId,groupRequest);
        }
        @GetMapping("/{id}")
        public GroupResponse getGroupById(@PathVariable Long id){

            return   service.getGroupById(id);
        }
        @PutMapping("/{id}")
        public GroupResponse  updateGroup(@PathVariable Long id,@RequestBody GroupRequest groupRequest){
            return service.updateGroups(id,groupRequest);

        }

        @DeleteMapping("/{id}")
        public SimpleResponse deleteGroupById(@PathVariable Long id){
            service.deleteGroupById(id);
            return new SimpleResponse("DELETED",  "Group with "+id+"  deleted");
        }
        @PostMapping({"/{courseId}/{groupId}"})
        public SimpleResponse assignGroupToCourse(@PathVariable Long courseId,@PathVariable Long groupId){
            service.assignGroupToCourse(courseId,groupId);
            return new SimpleResponse(
                    "assign","instructor with id "
                    +courseId+" assign to company with id "+groupId);
        }

    }
