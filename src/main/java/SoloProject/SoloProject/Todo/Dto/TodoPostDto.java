package SoloProject.SoloProject.Todo.Dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoPostDto {
    @NotBlank
    private Long todoId;
    @NotBlank
    private String title;

    @NotBlank
    private int orders;

    private boolean completed;
}
