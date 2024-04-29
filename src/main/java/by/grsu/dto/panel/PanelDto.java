package by.grsu.dto.panel;

import by.grsu.dto.task.TaskDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PanelDto {
    private long uuid;
    private String name;
    private List<TaskDto> tasks;
}
