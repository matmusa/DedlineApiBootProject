package peaksoft.dedlineapibootproject.service;

import peaksoft.dedlineapibootproject.dto.*;

import java.util.List;

public interface TaskService {
    TaskResponse saveTask(TaskRequest taskRequest);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> getAllTask();
    TaskResponse updateTaskById(Long id,TaskRequest taskRequestRequest);
    SimpleResponse deleteTaskById(Long id);
}
