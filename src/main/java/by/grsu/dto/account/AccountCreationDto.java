package by.grsu.dto.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreationDto {
    private String firstname;
    private String lastname;
}
