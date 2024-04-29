package by.grsu.dto.mapper;

import by.grsu.dto.project.ProjectBaseDto;
import by.grsu.dto.project.ProjectCreationDto;
import by.grsu.dto.project.ProjectFullDto;
import by.grsu.entity.Project;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProjectDtoMapper {
    public static ProjectFullDto convertEntityToFullDto(Project source){
        return ProjectFullDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .owner(AccountDtoMapper.convertEntityToBaseDto(source.getOwner()))
                .panels(source.getPanels().stream()
                        .map(PanelDtoMapper::convertEntityToDto)
                        .toList())
                .members(source.getMembers().stream()
                        .map(AccountDtoMapper::convertEntityToBaseDto)
                        .toList())
                .build();
    }

    public static ProjectBaseDto convertEntityToBaseDto(Project source){
        return ProjectBaseDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }

    public static Project convertDtoToEntity(ProjectCreationDto source){
        return Project.builder()
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
