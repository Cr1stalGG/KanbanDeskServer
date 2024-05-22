package by.grsu.controller;

import by.grsu.dto.task.MoveTaskDto;
import by.grsu.dto.task.TaskCreationDto;
import by.grsu.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public void save(@RequestBody TaskCreationDto creationDto){
        taskService.save(creationDto);
    }

    @PostMapping
    public void moveTask(@RequestBody MoveTaskDto moveTaskDto){
        taskService.moveTask(moveTaskDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }
}
