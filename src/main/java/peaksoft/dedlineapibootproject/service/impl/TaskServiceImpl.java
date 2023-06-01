package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.TaskRequest;
import peaksoft.dedlineapibootproject.dto.TaskResponse;
import peaksoft.dedlineapibootproject.repository.TaskRepository;
import peaksoft.dedlineapibootproject.service.TaskService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse saveTask(TaskRequest taskRequest) {
        return null;
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return null;
    }

    @Override
    public List<TaskResponse> getAllTask() {
        return null;
    }

    @Override
    public TaskResponse updateTaskById(Long id, TaskRequest taskRequestRequest) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }
}
