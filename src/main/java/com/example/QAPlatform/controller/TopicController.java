package com.example.QAPlatform.controller;

import com.example.QAPlatform.model.Topic;
import com.example.QAPlatform.service.TopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(value = "/api/v1",consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TopicController {

    @Autowired
    TopicManager manager;

    @PostMapping("/topic")
    @ResponseBody
    public void addTopic(@RequestBody Topic topic) {
        manager.addTopic(topic);
    }

    @PostMapping("/subtopic")
    @ResponseBody
    public void addSubtopic(@RequestBody Topic topic){
        manager.addSubtopic(topic);
    }
    /*
    @GetMapping("/tag/{id}")
    @ResponseBody
    public ArrayList<String> getAllTags(@PathVariable String id){
        return manager.getAllTags(id);
    }

    @DeleteMapping("/tag/{id}/{tag}")
    @ResponseBody
    public void deleteCompany(@PathVariable String id, @PathVariable String tag){
        manager.deleteTag(id, tag);
    }

    @PostMapping("/tag/{id}/{tag}")
    @ResponseBody
    public void updateCompany(@PathVariable String id, @PathVariable String tag, @RequestBody Tags newTag){
        manager.updateTag(id,tag, newTag);
    }*/
}
