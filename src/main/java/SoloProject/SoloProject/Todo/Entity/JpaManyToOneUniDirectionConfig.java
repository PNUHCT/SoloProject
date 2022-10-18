//package SoloProject.SoloProject.Todo.Entity;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//@Configuration
//public class JpaManyToOneUniDirectionConfig {
//    private EntityManager em;
//    private EntityTransaction tx;
//    @Bean
//    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
//        this.em = emFactory.createEntityManager();
//        this.tx = em.getTransaction();
//        return args -> {
//            mappingManyToOneUniDirection();
////            mappingOneToOneUniDirection();
//        };
//    }
//
//    private void mappingManyToOneUniDirection() {
//        tx.begin();
//
//        Todo todo = new Todo(1L, "타이틀", 500, false);
//        em.persist(todo);
//
//        tx.commit();
//
//        Todo findTodo = em.find(Todo.class, 1L);
//        System.out.println("Todo : " + findTodo.getTitle());
//    }
//}
