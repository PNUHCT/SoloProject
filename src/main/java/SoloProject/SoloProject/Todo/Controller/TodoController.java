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
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RequestMapping("/v1/todo")
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
    public ResponseEntity postTodo(@RequestBody TodoPostDto todoPostDto) {
        Todo todo = todoService.createTodo(mapper.todoPostDtoToTodo(todoPostDto));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive Long todoId, @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setTodoId(todoId);
        Todo todo = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") Long todoId) {
        Todo todo = todoService.findTodo(todoId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.todoToTodoResponseDto(todo)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodoList(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Todo> pageTodoList = todoService.findTodoList(page-1, size);
        List<Todo> todoList = pageTodoList.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(mapper.todoToTodoResponseDtos(todoList), pageTodoList), HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public void deleteTodoList() {
        todoService.deleteTodoList();
    }
}