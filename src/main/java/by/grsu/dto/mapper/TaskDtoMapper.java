package by.grsu.dto.mapper;

import by.grsu.dto.task.TaskCreationDto;
import by.grsu.dto.task.TaskDto;
import by.grsu.entity.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskDtoMapper {
    public static TaskDto convertEntityToDto(Task source){
        return TaskDto.builder()
                .uuid(source.getId())
                .title(source.getTitle())
                .description(source.getDescription())
                .color(source.getColor())
                .accounts(source.getAccounts().stream()
                        .map(AccountDtoMapper::convertEntityToBaseDto)
                        .toList())
                .comments(source.getComments().stream()
                        .map(CommentDtoMapper::convertEntityToDto)
                        .toList())
                .build();
    }

    public static Task convertDtoToEntity(TaskCreationDto source){
        return Task.builder()
                .title(source.getTitle())
                .description(source.getDescription())
                .color(source.getColor())
                .deadline(source.getDeadline())
                .build();
    }
}
