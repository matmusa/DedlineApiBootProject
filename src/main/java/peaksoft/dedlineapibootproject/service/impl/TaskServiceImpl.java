package peaksoft.dedlineapibootproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dedlineapibootproject.dto.SimpleResponse;
import peaksoft.dedlineapibootproject.dto.TaskRequest;
import peaksoft.dedlineapibootproject.dto.TaskResponse;
import peaksoft.dedlineapibootproject.entity.Lesson;
import peaksoft.dedlineapibootproject.entity.Task;
import peaksoft.dedlineapibootproject.repository.LessonRepository;
import peaksoft.dedlineapibootproject.repository.TaskRepository;
import peaksoft.dedlineapibootproject.service.TaskService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;

    @Override
    public TaskResponse saveTask(Long lessonId,TaskRequest taskRequest) {
        Lesson lesson =
                lessonRepository.findLessonById(lessonId).orElseThrow(()
                        -> new NullPointerException("Lesson with id " + lessonId + "  is not found "));
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        taskRepository.save(task);
        lesson.getTasks().add(task);
        lessonRepository.save(lesson);
        return new TaskResponse(
                task.getId(),
                task.getTaskName(),
                task.getTaskText());
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = new Task();
        taskRepository.findTaskById(id).orElseThrow(() ->
                new NullPointerException("Lesson with id " + id + "  is not found "));
        return new TaskResponse(
                task.getId(),
                task.getTaskName(),
                task.getTaskText());
    }

    @Override
    public List<TaskResponse> getAllTask() {
        return taskRepository.getAllTasks();
    }

    @Override
    public TaskResponse updateTaskById(Long id, TaskRequest taskRequestRequest) {

        Task task = taskRepository.findTaskById(id).orElseThrow(() ->
                new NullPointerException("Lesson with id " + id + "  is not found "));
        task.setTaskName(taskRequestRequest.getTaskName());
        task.setTaskText(taskRequestRequest.getTaskText());
        taskRepository.save(task);
        return new TaskResponse(
                task.getId(),
                task.getTaskName(),
                task.getTaskText());
    }

    @Override
    public SimpleResponse deleteTaskById(Long id) {
        boolean exist = taskRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        taskRepository.deleteById(id);
        return new SimpleResponse("DELETED","Student with id: " + id + " is deleted");

    }
}
