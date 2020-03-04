package io.guiders.api.controller;

import io.guiders.api.repository.AnswerRepository;
import io.guiders.api.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QnAController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public ResponseEntity<?> registerQuestion() {

        return ResponseEntity.created(null).build();
    }

}
