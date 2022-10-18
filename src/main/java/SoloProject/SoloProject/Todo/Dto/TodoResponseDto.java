package SoloProject.SoloProject.Todo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Builder
@Getter
public class TodoResponseDto {
    private int id;
    private String title;
    private int orders;
    private boolean completed;
}
