package by.grsu.service.impl;

import by.grsu.dto.mapper.ProjectDtoMapper;
import by.grsu.dto.project.ProjectBaseDto;
import by.grsu.dto.project.ProjectCreationDto;
import by.grsu.dto.project.ProjectFullDto;
import by.grsu.entity.Account;
import by.grsu.entity.Project;
import by.grsu.repository.AccountRepository;
import by.grsu.repository.ProjectRepository;
import by.grsu.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<ProjectBaseDto> findAllOwnProjects(long accountId) {
        return accountRepository.findById(accountId).getOwnProjects().stream()
                .map(ProjectDtoMapper::convertEntityToBaseDto)
                .toList();
    }

    @Override
    public List<ProjectBaseDto> findAllWorkingProjects(long accountId) {
        return accountRepository.findById(accountId).getWorkingProjects().stream()
                .map(ProjectDtoMapper::convertEntityToBaseDto)
                .toList();
    }

    @Override
    public ProjectFullDto findById(long id) {
        return ProjectDtoMapper.convertEntityToFullDto(projectRepository.findById(id));
    }

    @Override
    public void saveOwn(ProjectCreationDto creationDto) {
        Account account = accountRepository.findById(creationDto.getAccountId());

        Project project = ProjectDtoMapper.convertDtoToEntity(creationDto);
        project.setOwner(account);
        projectRepository.save(project);

        account.getOwnProjects().add(project);
        accountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {

    }
}
