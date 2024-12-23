package com.Abhishek.QuizQuestionService.Service;

import com.Abhishek.QuizQuestionService.entity.ClientResponse;
import com.Abhishek.QuizQuestionService.entity.QuestionWrapper;
import com.Abhishek.QuizQuestionService.entity.Questions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    List<Questions> getAllQuestions();

    void saveQuestions(Questions questions);

    List<Questions> getByCategory(String Category);

    ResponseEntity<List<Integer>> getQuestions(String category, Integer numQ);

    ResponseEntity<List<QuestionWrapper>> getQuestionsByID(List<Integer> questionsID);

    ResponseEntity<String> calculateScore(List<ClientResponse> clientResponse);
}
