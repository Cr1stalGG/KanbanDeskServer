package by.grsu.dto.comment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentCreationDto {
    private String message;
    private long ownerId;
}
