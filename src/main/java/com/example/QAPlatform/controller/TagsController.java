package com.example.QAPlatform.controller;

import com.example.QAPlatform.model.Tags;
import com.example.QAPlatform.service.TagsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/api/v1",consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TagsController {

    @Autowired
    TagsManager manager;

    @PostMapping("/tag")
    @ResponseBody
    public void addTag(@RequestBody Tags tag){
        manager.addTag(tag);
    }

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
    }
}
