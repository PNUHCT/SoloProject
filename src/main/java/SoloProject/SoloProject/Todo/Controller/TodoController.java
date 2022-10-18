package SoloProject.SoloProject.Todo.Controller;

import SoloProject.SoloProject.Todo.Dto.TodoPatchDto;
import SoloProject.SoloProject.Todo.Dto.TodoPostDto;
import SoloProject.SoloProject.Todo.Entity.Todo;
import SoloProject.SoloProject.Todo.Mapper.TodoMapper;
import SoloProject.SoloProject.Todo.Service.TodoService;
import SoloProject.SoloProject.Todo.response.MultiResponseDto;
import SoloProject.SoloProject.Todo.response.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@Validated
@RequestMapping("/v2/todo")
@RestController
@Slf4j
public class TodoController {
    private TodoMapper mapper;
    private TodoService todoService;

    public TodoController(TodoMapper mapper, TodoService todoService) {
        this.mapper = mapper;
        this.todoService = todoService;
    }


    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo todo = todoService.createTodo(mapper.todoPostDtoToTodo(todoPostDto));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(@PathVariable("id") @Positive int id, @Valid @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setId(id);
        Todo todo = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable("id") int id) {
        Todo todo = todoService.findTodo(id);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodoList(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Todo> pageTodoList = todoService.findTodoList(page-1, size);
        List<Todo> todoList = pageTodoList.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(mapper.todoToTodoResponseDtos(todoList), pageTodoList), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public void deleteTodoList() {
        todoService.deleteTodoList();
    }
}