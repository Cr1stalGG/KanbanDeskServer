package by.grsu.service.impl;

import by.grsu.dto.mapper.PanelDtoMapper;
import by.grsu.dto.panel.PanelCreationDto;
import by.grsu.entity.Panel;
import by.grsu.entity.Project;
import by.grsu.repository.PanelRepository;
import by.grsu.repository.ProjectRepository;
import by.grsu.service.PanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PanelServiceImpl implements PanelService {
    private final ProjectRepository projectRepository;
    private final PanelRepository panelRepository;

    @Override
    @Transactional
    public void save(PanelCreationDto creationDto) {
        Project project = projectRepository.findById(creationDto.getProjectId());

        Panel panel = PanelDtoMapper.convertDtoToEntity(creationDto);

        panelRepository.save(panel);

        project.getPanels().add(panel);
        projectRepository.save(project);
    }

    @Override
    public void deleteById(long id) {
        projectRepository.deleteById(id);
    }
}
