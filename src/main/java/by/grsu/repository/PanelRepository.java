package by.grsu.repository;

import by.grsu.entity.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {
    Panel findById(long id);
    void deleteById(long id);
}
