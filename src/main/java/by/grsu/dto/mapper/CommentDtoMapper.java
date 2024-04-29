package by.grsu.dto.mapper;

import by.grsu.dto.comment.CommentCreationDto;
import by.grsu.dto.comment.CommentDto;
import by.grsu.entity.Comment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommentDtoMapper {
    public static CommentDto convertEntityToDto(Comment source){
        return CommentDto.builder()
                .uuid(source.getId())
                .message(source.getMessage())
                .owner(AccountDtoMapper.convertEntityToBaseDto(source.getOwner()))
                .build();
    }

    public static Comment convertDtoToEntity(CommentCreationDto source){
        return Comment.builder()
                .message(source.getMessage())
                .build();
    }
}
