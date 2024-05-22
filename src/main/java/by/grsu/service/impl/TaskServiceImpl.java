package by.grsu.service.impl;

import by.grsu.dto.mapper.TaskDtoMapper;
import by.grsu.dto.task.MoveTaskDto;
import by.grsu.dto.task.TaskCreationDto;
import by.grsu.entity.Panel;
import by.grsu.entity.Task;
import by.grsu.repository.PanelRepository;
import by.grsu.repository.TaskRepository;
import by.grsu.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final PanelRepository panelRepository;

    @Override
    @Transactional
    public void save(TaskCreationDto creationDto) {
        Panel panel = panelRepository.findById(creationDto.getPanelId());
        Task task = TaskDtoMapper.convertDtoToEntity(creationDto);

        taskRepository.save(task);

        panel.getTasks().add(task);
        panelRepository.save(panel);
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void moveTask(MoveTaskDto moveTaskDto) {
        Task task = taskRepository.findById(moveTaskDto.getTaskId());

        Panel fromPanel = panelRepository.findById(moveTaskDto.getFromPanelId());
        Panel toPanel = panelRepository.findById(moveTaskDto.getToPanelId());
    }
}
