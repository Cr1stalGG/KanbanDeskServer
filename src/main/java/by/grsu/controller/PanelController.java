package by.grsu.controller;

import by.grsu.dto.panel.PanelCreationDto;
import by.grsu.service.PanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/panels")
@RequiredArgsConstructor
public class PanelController {
    private final PanelService panelService;

    @PostMapping
    public void save(@RequestBody PanelCreationDto creationDto){
        panelService.save(creationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        panelService.deleteById(id);
    }
}
