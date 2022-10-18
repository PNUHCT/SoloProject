package SoloProject.SoloProject.Todo.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TodoPatchDto {
    private int id;
    @NotBlank
    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "제목은 영문이어야 합니다(단어 사이 공백 한 칸 포함")
    private String title;
    private int orders;
    private boolean completed;
}