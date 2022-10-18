package SoloProject.SoloProject.Todo.Dto;

import SoloProject.SoloProject.Todo.CustomVaidator.NotSpace;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class TodoPostDto {
    private int id;

    @NotBlank
    @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "제목은 영문이어야 합니다(단어 사이 공백 한 칸 포함")
    private String title;

    @Range(min = 0, max =50000)
    private int orders;

    private boolean completed;
}
