package SoloProject.SoloProject.Todo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.net.URI;


@AllArgsConstructor
@Builder
@Getter
public class TodoResponseDto {
    private int id;
    private String title;
    private int orders;
    private boolean completed;
    private URI uri;
}
