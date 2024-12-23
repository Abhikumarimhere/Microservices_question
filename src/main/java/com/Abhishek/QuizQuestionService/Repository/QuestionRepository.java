package com.Abhishek.QuizQuestionService.Repository;

import com.Abhishek.QuizQuestionService.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {

    List<Questions> findByCategory(String category);
    @Query(value = "SELECT q.id FROM questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category,Integer numQ);
}
