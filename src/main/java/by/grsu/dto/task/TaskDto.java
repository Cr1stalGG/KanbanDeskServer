package by.grsu.dto.task;

import by.grsu.dto.account.AccountBaseDto;
import by.grsu.dto.comment.CommentDto;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class TaskDto {
    private long uuid;
    private String title;
    private String description;
    private Date deadline;
    private String color;
    private List<CommentDto> comments;
    private List<AccountBaseDto> accounts;
}
