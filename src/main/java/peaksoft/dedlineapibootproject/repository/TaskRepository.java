package peaksoft.dedlineapibootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.dedlineapibootproject.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
