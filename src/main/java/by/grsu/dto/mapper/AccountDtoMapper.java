package by.grsu.dto.mapper;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.account.AccountFullDto;
import by.grsu.dto.security.AuthRequest;
import by.grsu.entity.Account;
import by.grsu.entity.enums.Role;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

@UtilityClass
public class AccountDtoMapper {
    public static AccountFullDto convertEntityToFullDto(Account source){
        return AccountFullDto.builder()
                .uuid(source.getId())
                .firstname(source.getFirstname())
                .lastname(source.getLastname())
                .ownProjects(source.getOwnProjects().stream()
                        .map(ProjectDtoMapper::convertEntityToBaseDto)
                        .toList())
                .workingProjects(source.getWorkingProjects().stream()
                        .map(ProjectDtoMapper::convertEntityToBaseDto)
                        .toList())
                .build();
    }

    public static AccountBaseDto convertEntityToBaseDto(Account source) {
        return AccountBaseDto.builder()
                .uuid(source.getId())
                .firstname(source.getFirstname())
                .lastname(source.getLastname())
                .build();
    }

    public static Account convertDtoToEntity(AuthRequest source){
        final String userLoginPattern = "^[a-zA-Z]*_[a-zA-Z]{2}_[0-9]{2}$";

        Account account = Account.builder()
                .login(source.getLogin())
                .password(new BCryptPasswordEncoder(12).encode(source.getPassword()))
                .build();

        if(Pattern.matches(userLoginPattern, source.getLogin()))
            account.setRole(Role.ROLE_USER);
        else
            account.setRole(Role.ROLE_ADMIN);

        return account;
    }

}
