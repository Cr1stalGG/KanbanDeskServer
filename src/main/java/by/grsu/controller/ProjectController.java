package by.grsu.controller;

import by.grsu.dto.project.ProjectBaseDto;
import by.grsu.dto.project.ProjectCreationDto;
import by.grsu.dto.project.ProjectFullDto;
import by.grsu.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/own/{accountId}")
    public List<ProjectBaseDto> findAllOwnProjects(@PathVariable long accountId){
        return projectService.findAllOwnProjects(accountId);
    }

    @GetMapping("/working/{accountId}")
    public List<ProjectBaseDto> findAllWorkingProjects(@PathVariable long accountId){
        return projectService.findAllWorkingProjects(accountId);
    }

    @GetMapping("/{id}")
    public ProjectFullDto findById(@PathVariable long id){
        return projectService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ProjectCreationDto creationDto){
        projectService.saveOwn(creationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        projectService.deleteById(id);
    }
}
