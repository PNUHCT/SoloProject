package SoloProject.SoloProject.Todo.Repository;

import SoloProject.SoloProject.Todo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
//    @Override
    Optional<Todo> findById(int id);

    @Query(value = "SELECT c FROM Todo c WHERE c.id = :id")
    Optional<Todo> findByTodo(int id);
}
