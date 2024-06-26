package by.grsu.service;

import by.grsu.dto.task.MoveTaskDto;
import by.grsu.dto.task.TaskCreationDto;

public interface TaskService {
    void save(TaskCreationDto creationDto);
    void deleteById(long id);
    void moveTask(MoveTaskDto moveTaskDto);
}
