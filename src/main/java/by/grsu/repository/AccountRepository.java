package by.grsu.repository;

import by.grsu.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
    Account findByLogin(String login);
    List<Account> findAll();
    void deleteById(long id);
    boolean existsByLogin(String login);
}
