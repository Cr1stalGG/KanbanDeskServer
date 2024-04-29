package by.grsu.repository;

import by.grsu.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findById(long id);
    List<Project> findAllByName(String name);
    List<Project> findAll();
    void deleteById(long id);
}
