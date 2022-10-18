package SoloProject.SoloProject.Todo.Mapper;

import SoloProject.SoloProject.Todo.Dto.TodoPatchDto;
import SoloProject.SoloProject.Todo.Dto.TodoPostDto;
import SoloProject.SoloProject.Todo.Dto.TodoResponseDto;
import SoloProject.SoloProject.Todo.Entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    List<TodoResponseDto> todoToTodoResponseDtos(List<Todo> todos);
}
