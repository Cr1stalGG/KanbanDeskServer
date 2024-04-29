package by.grsu.dto.panel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanelCreationDto {
    private String name;
    private long projectId;
}
