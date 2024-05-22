package by.grsu.dto.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectAddMemberDto {
    private long accountId;
    private long projectId;
}
