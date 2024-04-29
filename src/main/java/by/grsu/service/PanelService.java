package by.grsu.service;

import by.grsu.dto.panel.PanelCreationDto;

public interface PanelService {
    void save(PanelCreationDto creationDto);
    void deleteById(long id);
}
