package by.grsu.service;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.account.AccountCreationDto;
import by.grsu.dto.account.AccountFullDto;

import java.util.List;

public interface AccountService {
    AccountFullDto findById(long id);
    List<AccountBaseDto> findAll();
    void save(long id, AccountCreationDto creationDto);
    void deleteById(long id);
}
