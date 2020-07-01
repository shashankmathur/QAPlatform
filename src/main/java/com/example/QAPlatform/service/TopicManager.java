package com.example.QAPlatform.service;

import com.example.QAPlatform.dao.TagsDao;
import com.example.QAPlatform.dao.TopicDao;
import com.example.QAPlatform.model.TagId;
import com.example.QAPlatform.model.Tags;
import com.example.QAPlatform.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TopicManager {

    @Autowired
    TopicDao topicDao;

    public ResponseEntity<String> addTopic(Topic topic){

        if(topic.getTopic() != null || topic.getQuestionId() != null || topic.getSubtopic() != null){
            return new ResponseEntity<>(
                    "One or more mandatory parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }
        topic.setTopicId(createMapforTopic().get(topic.getTopic()));
        topic.setSubtopicId(createMapforSubtopic().get(topic.getSubtopic()));

        try{
            topicDao.save(topic);
            return new ResponseEntity<>(
                    "Successfully Added new topic",
                    HttpStatus.OK
            );
        }
        catch(Exception e){
            return new ResponseEntity<>(
                    "Failed to write to database",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    private static HashMap<String, String> createMapforTopic(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Data Structure","1");
        map.put("Algorithm","2");
        return map;
    }

    private static HashMap<String, String> createMapforSubtopic(){
        HashMap<String, String> map = new HashMap<>();
        map.put("greedy algo","1");
        map.put("arrays","2");
        map.put("sorting","3");
        map.put("linked list","4");
        map.put("trees","5");
        return map;
    }

    /*
    public ArrayList<String> getAllTags(String id){

        List<Tags> data = tagsDao.findAll();
        ArrayList<String> tags = new ArrayList<>();
        data.forEach((tag) ->{
            if(tag.getQuestionId().equals(id)){
                tags.add(tag.getTag());
            }
        });
        return tags;
    }

    public void deleteTag(String id, String tag){
        TagId tagId = new TagId(id,tag);
        tagsDao.deleteById(tagId);
    }

    public void updateTag(String id, String tag, Tags newTag )
    {
        TagId tagId = new TagId(id,tag);
        tagsDao.deleteById(tagId);

        newTag.setQuestionId(id);
        tagsDao.save(newTag);
    }*/

}
