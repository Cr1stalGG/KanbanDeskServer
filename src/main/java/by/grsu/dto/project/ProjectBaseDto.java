package by.grsu.dto.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBaseDto {
    private long uuid;
    private String name;
    private String description;
}
