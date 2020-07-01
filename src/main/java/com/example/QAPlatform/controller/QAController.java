package com.example.QAPlatform.controller;

import com.example.QAPlatform.model.*;
import com.example.QAPlatform.service.QAManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RequestMapping(value = "/api/v1",consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class QAController {

    @Autowired
    QAManager manager;

    @PostMapping("/question")
    @ResponseBody
    public ResponseEntity<String> postQuestion(@RequestBody QuestionInput input){

        return manager.postQuestion(input);
    }

    @PostMapping("/answer")
    @ResponseBody
    public ResponseEntity<String> postAnswer(@RequestBody Answer answer){
        return manager.postAnswer(answer);
    }

    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<String> postComment(@RequestBody Comment comment){
        return manager.postComment(comment);
    }

    @PostMapping("/question_likes")
    @ResponseBody
    public ResponseEntity<String> likeQuestion(@RequestBody QuestionLikes questionLikes){
        return manager.likeQuestion(questionLikes);
    }

    @PostMapping("/answer_likes")
    @ResponseBody
    public ResponseEntity<String> likeAnswer(@RequestBody AnswerLikes answerLikes){
        return manager.likeAnswer(answerLikes);
    }

    @GetMapping("/question/{id}")
    @ResponseBody
    public ResponseEntity<getQuestionOutput> getQuestionById(@PathVariable String id){
        return manager.getQuestionById(id);
    }

    @GetMapping("/question")
    @ResponseBody
    public ResponseEntity<FilterQuestionOutput[]> filterQuestion(@RequestParam(name="company",required = false) String companies,
                                                    @RequestParam(name="subtopic",required=false) String subtopics,
                                                    @RequestParam(name="likes",required=false) Integer likes,
                                                    @RequestParam(name="date",required=false) String date,
                                                    @RequestParam(name="tags",required=false) String tags){

        return manager.filterQuestion(companies,subtopics,likes,date,tags);
    }

}
