package com.example.QAPlatform.service;

import com.example.QAPlatform.dao.TagsDao;
import com.example.QAPlatform.model.TagId;
import com.example.QAPlatform.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsManager {

    @Autowired
    TagsDao tagsDao;

    public void addTag(Tags tag){
        tagsDao.save(tag);
    }

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
    }

}
