package by.grsu.dto.account;

import by.grsu.dto.project.ProjectBaseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountFullDto {
    private long uuid;
    private String firstname;
    private String lastname;
    private List<ProjectBaseDto> ownProjects;
    private List<ProjectBaseDto> workingProjects;
}
