package by.grsu.dto.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectCreationDto {
    private String name;
    private String description;
    private long accountId;
}
