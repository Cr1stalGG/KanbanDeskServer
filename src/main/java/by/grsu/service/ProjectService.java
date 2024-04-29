package by.grsu.service;

import by.grsu.dto.project.ProjectBaseDto;
import by.grsu.dto.project.ProjectCreationDto;
import by.grsu.dto.project.ProjectFullDto;

import java.util.List;

public interface ProjectService {
    List<ProjectBaseDto> findAllOwnProjects(long accountId);
    List<ProjectBaseDto> findAllWorkingProjects(long accountId);
    ProjectFullDto findById(long id);
    void saveOwn(ProjectCreationDto creationDto);
    void deleteById(long id);

}
