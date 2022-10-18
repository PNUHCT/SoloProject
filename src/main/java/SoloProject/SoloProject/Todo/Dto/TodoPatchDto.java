package SoloProject.SoloProject.Todo.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoPatchDto {
    private Long todoId;
    private String title;
    private int orders;
    private boolean completed;
}
