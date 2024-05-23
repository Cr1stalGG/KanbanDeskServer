package by.grsu.dto.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountBaseDto {
    private long uuid;//asd
    private String firstname;
    private String lastname;
}
