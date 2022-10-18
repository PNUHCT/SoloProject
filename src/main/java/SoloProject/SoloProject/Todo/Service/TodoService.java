package SoloProject.SoloProject.Todo.Service;

import SoloProject.SoloProject.Todo.Entity.Todo;
import SoloProject.SoloProject.Todo.Exception.BusinessLogicException;
import SoloProject.SoloProject.Todo.Exception.ExceptionCode;
import SoloProject.SoloProject.Todo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        // 비즈니스 로직작성 구간

        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        // 비즈니스 로직작성 구간
        Todo findTodo = findVerifiedTodo(todo.getId());
        Optional.ofNullable(todo.getTitle()).ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todo.getOrders()).ifPresent(orders -> findTodo.setOrders(orders));
        // boolean은 어떻게?

        return todoRepository.save(findTodo);
    }

    public Todo findTodo(int id) {
        return findVerifiedTodo(id);
    }

    public Page<Todo> findTodoList(int page, int size) {
        // 비즈니스 로직작성 구간
        return todoRepository.findAll(PageRequest.of(page, size, Sort.by("todoId").descending()));
    }

    public void deleteTodo(int id) {
        // 비즈니스 로직작성 구간
        Todo todo = findVerifiedTodo(id);
        todoRepository.delete(todo);
    }

    public void deleteTodoList() {
        // 비즈니스 로직작성 구간
        todoRepository.deleteAll();
    }

    // private 메서드----------------

    private Todo findVerifiedTodo(int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo findTodo = optionalTodo
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return findTodo;
    }
}
