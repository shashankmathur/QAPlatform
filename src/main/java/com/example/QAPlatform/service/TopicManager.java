package com.example.QAPlatform.service;

import com.example.QAPlatform.dao.TagsDao;
import com.example.QAPlatform.dao.TopicDao;
import com.example.QAPlatform.model.TagId;
import com.example.QAPlatform.model.Tags;
import com.example.QAPlatform.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TopicManager {

    @Autowired
    TopicDao topicDao;

    public String addTopic(Topic topic){
        topic.setTopicId(UUID.randomUUID().toString());
        if(!topic.getSubtopic().equals(null)){
            topic.setSubtopicId(UUID.randomUUID().toString());
        }
        try{
            topicDao.save(topic);
            return "Successfully Added new topic";
        }
        catch(Exception e){
            return "Failed";
        }
    }

    public void addSubtopic(Topic topic){
        topic.setSubtopicId(UUID.randomUUID().toString());
        topicDao.save(topic);
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
