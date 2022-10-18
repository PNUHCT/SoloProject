package SoloProject.SoloProject.Todo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private int orders;

    @Column(nullable = false)
    private boolean completed;

    public Todo(Long todoId) {
        this.todoId = todoId;
    }

    public Todo(Long todoId, String title, int orders, boolean completed) {
        this.todoId = todoId;
        this.title = title;
        this.orders = orders;
        this.completed = completed;
    }

    // todo 상태
//    public enum TodoStatus {
//        UNFINISHED("작성중"),
//        UNDO("미완"),
//        DONE("완");
//        @Getter
//        private String status;
//        TodoStatus(String status) {this.status = status;}
//    }
}
