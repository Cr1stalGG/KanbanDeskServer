package by.grsu.dto.task;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoveTaskDto {
    private long fromPanelId;
    private long toPanelId;
    private long taskId;
}
