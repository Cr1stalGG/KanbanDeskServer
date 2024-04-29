package by.grsu.dto.mapper;

import by.grsu.dto.panel.PanelCreationDto;
import by.grsu.dto.panel.PanelDto;
import by.grsu.entity.Panel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PanelDtoMapper {
    public static PanelDto convertEntityToDto(Panel source){
        return PanelDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .tasks(source.getTasks().stream()
                        .map(TaskDtoMapper::convertEntityToDto)
                        .toList())
                .build();
    }

    public static Panel convertDtoToEntity(PanelCreationDto source){
        return Panel.builder()
                .name(source.getName())
                .build();
    }
}
