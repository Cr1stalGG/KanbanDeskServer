package by.grsu.dto.task;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class TaskCreationDto {
    private String title;
    private String description;
    private Date deadline;
    private String color;
    private long panelId;
}
