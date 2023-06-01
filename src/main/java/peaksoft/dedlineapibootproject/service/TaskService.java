package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.StudentRequest;
import peaksoft.dedlineapibootproject.dto.StudentResponse;
import peaksoft.dedlineapibootproject.dto.TaskRequest;
import peaksoft.dedlineapibootproject.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse saveTask(TaskRequest taskRequest);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> getAllTask();
    TaskResponse updateTaskById(Long id,TaskRequest taskRequestRequest);
    void deleteTaskById(Long id);
}
