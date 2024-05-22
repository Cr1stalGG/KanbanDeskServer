package by.grsu.controller;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.account.AccountCreationDto;
import by.grsu.dto.account.AccountFullDto;
import by.grsu.service.AccountService;
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
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountBaseDto> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountFullDto findById(@PathVariable long id){
        return accountService.findById(id);
    }

    @GetMapping("/login/{login}")
    public AccountFullDto findByLogin(@PathVariable String login){
        return accountService.findByLogin(login);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable long id, @RequestBody AccountCreationDto creationDto){
        accountService.save(id, creationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        accountService.deleteById(id);
    }
}
