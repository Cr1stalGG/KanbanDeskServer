package by.grsu.service.impl;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.account.AccountCreationDto;
import by.grsu.dto.account.AccountFullDto;
import by.grsu.dto.mapper.AccountDtoMapper;
import by.grsu.entity.Account;
import by.grsu.repository.AccountRepository;
import by.grsu.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService { //todo add optional with exceptions and RestControllerAdvice
    private final AccountRepository accountRepository;

    @Override
    public AccountFullDto findById(long id) {
        return AccountDtoMapper.convertEntityToFullDto(accountRepository.findById(id));
    }

    @Override
    public List<AccountBaseDto> findAll() {
        return accountRepository.findAll().stream()
                .map(AccountDtoMapper::convertEntityToBaseDto)
                .toList();
    }

    @Override
    @Transactional
    public void save(long id, AccountCreationDto creationDto) {
        Account account = accountRepository.findById(id);

        account.setFirstname(creationDto.getFirstname());
        account.setLastname(creationDto.getLastname());

        accountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }
}
