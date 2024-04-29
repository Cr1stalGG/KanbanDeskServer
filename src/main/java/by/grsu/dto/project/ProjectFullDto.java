package by.grsu.dto.project;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.panel.PanelDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProjectFullDto {
    private long uuid;
    private String name;
    private String description;
    private AccountBaseDto owner;
    private List<AccountBaseDto> members;
    private List<PanelDto> panels;
}
