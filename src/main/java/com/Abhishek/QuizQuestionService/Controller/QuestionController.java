package com.Abhishek.QuizQuestionService.Controller;


import com.Abhishek.QuizQuestionService.Service.QuestionService;
import com.Abhishek.QuizQuestionService.entity.ClientResponse;
import com.Abhishek.QuizQuestionService.entity.QuestionWrapper;
import com.Abhishek.QuizQuestionService.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestion")
    public String Question(){
        return "Here are your question";
    }
    @PostMapping("/Save")
    public ResponseEntity<Questions> SaveQuestions(@RequestBody Questions questions){
        questionService.saveQuestions(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @GetMapping("/AllQuestions")
    public List<Questions> getallQuestion(){
        List<Questions> ans=questionService.getAllQuestions();
        return ans;
    }

    @GetMapping("/category/{Category}")
    public List<Questions> getByCategory(@PathVariable("Category") String Category){
        List<Questions> ans=questionService.getByCategory(Category);
        return ans;
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestions(@RequestParam String category,
                                                      @RequestParam Integer numQ){
        return questionService.getQuestions(category,numQ);

    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> questionsID){
        return questionService.getQuestionsByID(questionsID);
    }

    @PostMapping("/getScore")
    public ResponseEntity<String> getScore(@RequestBody List<ClientResponse> clientResponses){
        return questionService.calculateScore(clientResponses);
    }
}
