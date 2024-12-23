package com.Abhishek.QuizQuestionService.Service;

import com.Abhishek.QuizQuestionService.Repository.QuestionRepository;
import com.Abhishek.QuizQuestionService.entity.ClientResponse;
import com.Abhishek.QuizQuestionService.entity.QuestionWrapper;
import com.Abhishek.QuizQuestionService.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceimpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void saveQuestions(Questions questions) {
        questionRepository.save(questions);
    }



    @Override
    public List<Questions> getByCategory(String Category) {
        return questionRepository.findByCategory(Category);
    }

    @Override
    public ResponseEntity<List<Integer>> getQuestions(String category, Integer numQ) {
        List<Integer> ans=questionRepository.findRandomQuestionByCategory(category,numQ);
        return ResponseEntity.status(HttpStatus.OK).body(ans);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByID( List<Integer> questionsID) {
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for(Integer i:questionsID){
            Questions questions=questionRepository.findById((long)i).get();
           QuestionWrapper questionWrapper=new QuestionWrapper(
                   questions.getId(),
                   questions.getQuestions(),
                   questions.getOption1(),
                   questions.getOption2(),
                   questions.getOption3(),
                   questions.getOption4()

           );
           questionWrappers.add(questionWrapper);
        }

        return ResponseEntity.status(HttpStatus.OK).body(questionWrappers);
    }

    @Override
    public ResponseEntity<String> calculateScore(List<ClientResponse> clientResponses) {
        int score=0;
        for(ClientResponse cl: clientResponses){
            Questions questions=questionRepository.findById(cl.getId()).get();
            if(questions.getAnswers().equalsIgnoreCase(cl.getResponse())){
                score++;
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("your score is : "+score);
    }
}
