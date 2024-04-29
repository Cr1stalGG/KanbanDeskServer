package by.grsu.dto.comment;

import by.grsu.dto.account.AccountBaseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private long uuid;
    private String message;
    private AccountBaseDto owner;
}
