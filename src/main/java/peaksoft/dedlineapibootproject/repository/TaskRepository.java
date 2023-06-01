package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dedlineapibootproject.dto.TaskResponse;
import peaksoft.dedlineapibootproject.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {



    @Query("select new peaksoft.dedlineapibootproject.dto.TaskResponse" +
            "(t.id,t.taskName,t.taskText)from Task t")
    List<TaskResponse>getAllTasks();

    Optional<Task>findTaskById(Long id);






















}
