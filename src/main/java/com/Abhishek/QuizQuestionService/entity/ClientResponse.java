package com.Abhishek.QuizQuestionService.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientResponse{

    private Long id;
    private String response;
}
