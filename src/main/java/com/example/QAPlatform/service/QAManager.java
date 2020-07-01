package com.example.QAPlatform.service;

import com.example.QAPlatform.dao.*;
import com.example.QAPlatform.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class QAManager {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuestionCompanyMappingDao questionCompanyMappingDao;

    @Autowired
    AnswerDao answerDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    QuestionLikedDao qlDao;

    @Autowired
    AnswerLikedDao alDao;

    @Autowired
    TagsDao tagsDao;

    @Autowired
    TopicDao topicDao;

    @Autowired
    CompanyDao companyDao;

    public ResponseEntity<String> postQuestion(QuestionInput input) {
        if(input.getQuestionText().equals(null) || input.getTopicId().equals(null) ||input.getSubtopicId().equals(null)|| input.getUserId().equals(null)){
            return new ResponseEntity<>(
                    "One or more mandatory parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }

        if(input.getQuestionText().length() < 50 || input.getQuestionText().length() > 500)
        {
            return new ResponseEntity<>(
                    "Length of question is incorrect",
                    HttpStatus.BAD_REQUEST
            );
        }

        String questionId = UUID.randomUUID().toString();
        Question question = new Question(questionId, input.getUserId(),input.getQuestionText());
        question.setCreatedOn(LocalDate.now());
        questionDao.save(question);

        if(!input.getCompanyId().equals(null)){
            QuestionCompanyMapping questionCompanyMapping = new QuestionCompanyMapping(questionId, input.getCompanyId());
            questionCompanyMappingDao.save(questionCompanyMapping);
        }

        String[] tags = input.getTags();
        for(int i = 0 ; i < tags.length; i++)
        {
            Tags tag = new Tags(questionId,tags[i]);
            tagsDao.save(tag);
        }

        String topicName = createMapforTopic().get(input.getTopicId());
        String subtopicName = createMapforSubtopic().get(input.getSubtopicId());
        Topic topic = new Topic(questionId,input.getTopicId(),topicName,input.getSubtopicId(),subtopicName);
        topicDao.save(topic);

        return new ResponseEntity<>(
                questionId,
                HttpStatus.OK
        );

    }

    private HashMap<String, String> createMapforTopic(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1","Data Structure");
        map.put("2","Algorithm");
        return map;
    }

    private HashMap<String, String> createMapforSubtopic(){
        HashMap<String, String> map = new HashMap<>();
        map.put("1","greedy algo");
        map.put("2","arrays");
        map.put("3","sorting");
        map.put("4","linked list");
        map.put("5","trees");
        return map;
    }

    public ResponseEntity<String> postAnswer(Answer answer){

        if(answer.getAnswer().equals(null) || answer.getQuestionId().equals(null) || answer.getUserId().equals(null)){
            return new ResponseEntity<>(
                    "One or more parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }

        if(answer.getAnswer().length() < 50 || answer.getAnswer().length() > 500)
        {
            return new ResponseEntity<>(
                    "Length of answer is incorrect",
                    HttpStatus.BAD_REQUEST
            );
        }

        answer.setAnswerId(UUID.randomUUID().toString());
        answer.setDate(LocalDate.now());
        try {
            answerDao.save(answer);
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    String.format("Failed to write to database"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return new ResponseEntity<>(
                answer.getAnswerId(),
                HttpStatus.OK
        );
    }

    public ResponseEntity<String> postComment(Comment comment){

        if(comment.getAnswerId().equals(null) || comment.getComment().equals(null) || comment.getUserId().equals(null)){
            return new ResponseEntity<>(
                    "One or more parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }

        if(comment.getComment().length() < 50 || comment.getComment().length() > 500)
        {
            return new ResponseEntity<>(
                    "Length of comment is incorrect",
                    HttpStatus.BAD_REQUEST
            );
        }

        comment.setCommentId(UUID.randomUUID().toString());
        comment.setCreatedOn(LocalDate.now());
        try {
            commentDao.save(comment);
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    String.format("Failed to write to database"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return new ResponseEntity<>(
                comment.getCommentId(),
                HttpStatus.OK
        );
    }

    public ResponseEntity<String> likeQuestion(QuestionLikes questionLikes){

        if(questionLikes.getQuestionId().equals(null) || questionLikes.getUserId().equals(null) ){
            return new ResponseEntity<>(
                    "One or more parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }

        questionLikes.setLikedOn(LocalDate.now());

        try {
            qlDao.save(questionLikes);
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    String.format("Failed to write to database"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return new ResponseEntity<>(
                "Successfully liked the question",
                HttpStatus.OK
        );
    }

    public ResponseEntity<String> likeAnswer(AnswerLikes answerLikes){

        if(answerLikes.getAnswerId().equals(null) || answerLikes.getUserId().equals(null) ){
            return new ResponseEntity<>(
                    "One or more parameters are null",
                    HttpStatus.BAD_REQUEST
            );
        }

        answerLikes.setLikedOn(LocalDate.now());

        try {
            alDao.save(answerLikes);
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    String.format("Failed to write to database"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return new ResponseEntity<>(
                "Successfully liked the answer",
                HttpStatus.OK
        );
    }

    public ResponseEntity<getQuestionOutput> getQuestionById(String id){

        Optional<Question> question = questionDao.findById(id);

        ArrayList<AnswerOutput> answers = new ArrayList<>();
        List<Answer> tempAnswers = answerDao.findAll();
        tempAnswers.forEach(tempAnswer ->{
            if(tempAnswer.getQuestionId().equals(id)){
                AnswerOutput answer = new AnswerOutput();

                answer.setUserId(tempAnswer.getUserId());
                answer.setAnswerText(tempAnswer.getAnswer());
                List<AnswerLikes> answerLikes = alDao.findAll();
                answer.setNumberOfLikes( (int) answerLikes.stream().filter(like -> like.getAnswerId().equals(tempAnswer.getAnswerId())).count());

                ArrayList<CommentOutput> comments = new ArrayList<>();
                List<Comment> tempComments = commentDao.findAll();
                tempComments.forEach(comment -> {
                    if(comment.getAnswerId().equals(tempAnswer.getAnswerId())){
                        comments.add(new CommentOutput(comment.getComment(),comment.getCreatedOn(),comment.getUserId()));
                    }
                });

                answer.setComments((CommentOutput[])comments.toArray());

                answers.add(answer);
            }
        });

        List<QuestionLikes> questionLikes = qlDao.findAll();
        int numberOfLikes = (int) questionLikes.stream().filter(like -> like.getQuestionId().equals(id)).count();

        ArrayList<String> companies = new ArrayList<>();
        List<QuestionCompanyMapping> questionCompanyMappings = questionCompanyMappingDao.findAll();
        questionCompanyMappings.forEach(mapping ->{
            if(mapping.getQuestionId().equals(id)){
                companies.add(companyDao.findById(mapping.getCompanyId()).get().getCompanyName());
            }
        });

        ArrayList<String> tags = new ArrayList<>();
        List<Tags> tagsList = tagsDao.findAll();
        tagsList.forEach(tag ->{
            if(tag.getQuestionId().equals(id)){
                tags.add(tag.getTag());
            }
        });

        ArrayList<String> topics = new ArrayList<>();
        List<Topic> topicList = topicDao.findAll();
        topicList.forEach(topic ->{
            if(topic.getQuestionId().equals(id)){
                tags.add(topic.getTopic());
            }
        });

        getQuestionOutput result = new getQuestionOutput();
        result.setQuestionText(question.get().getQuestion());
        result.setAnswers((AnswerOutput[]) answers.toArray());
        result.setNumberOfLikes(numberOfLikes);
        result.setCompanies((String[]) companies.toArray());
        result.setTags((String[]) tags.toArray());
        result.setTopics((String[]) topics.toArray());

        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }

    public ResponseEntity<FilterQuestionOutput[]> filterQuestion(String companies,String subtopics,Integer requiredLikes,String date,String tags){
        //HashMap<String, FilterQuestionOutput> map = new HashMap<>();

        Set<String> companySet = new HashSet<>();
        Set<String> subtopicSet = new HashSet<>();
        Set<String> tagSet = new HashSet<>();

        if(companies != null){
            String[] companyArray = companies.split(",");
            for(int i = 0 ; i < companyArray.length; i++)
            {
                companySet.add(companyArray[i]);
            }
        }

        if(subtopics != null){
            String[] subtopicArray = subtopics.split(",");
            for(int i = 0 ; i < subtopicArray.length; i++)
            {
                subtopicSet.add(subtopicArray[i]);
            }
        }

        if(tags != null){
            String[] tagArray = tags.split(",");
            for(int i = 0 ; i < tagArray.length; i++)
            {
                tagSet.add(tagArray[i]);
            }
        }

        //Filtered by date.
        List<Question> allQuestions = questionDao.findAll();
        ArrayList<String> filteredQuestionIdByDate = new ArrayList<>();
        if(date != null)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate thresholdDate = LocalDate.parse(date,formatter);

            allQuestions.forEach(question->{
                if(question.getCreatedOn().isAfter(thresholdDate) || question.getCreatedOn().isEqual(thresholdDate)){
                    filteredQuestionIdByDate.add(question.getQuestionId());
                }
            });

        } else{
            allQuestions.forEach(question->{
                filteredQuestionIdByDate.add(question.getQuestionId());
            });
        }


        /*filteredQuestionIdByDate.forEach(questionId ->{
            FilterQuestionOutput temp = new FilterQuestionOutput();
            temp.setQuestionId(questionId);
            map.put(questionId,temp);
        });*/

        //Filtered by likes
        List<QuestionLikes> questionLikesList = qlDao.findAll();
        ArrayList<String> filterQuestionIdByLikes = new ArrayList<>();
        if(requiredLikes != null){

            for (String questionId : filteredQuestionIdByDate) {
                int likes = (int) questionLikesList.stream().filter(like -> like.getQuestionId().equals(questionId)).count();
                if (likes >= requiredLikes) {
                    filterQuestionIdByLikes.add(questionId);
                    //FilterQuestionOutput temp = map.get(questionId);
                    //temp.setLikes(likes);
                    //map.replace(questionId, temp);
                }
            }
        }else{
            filterQuestionIdByLikes = filteredQuestionIdByDate;
        }


        //Filtered by company list
        List<QuestionCompanyMapping> questionCompanyMappingList =questionCompanyMappingDao.findAll();
        ArrayList<String> filteredQuestionIdByCompany = new ArrayList<>();
        if(companies != null){
            for (String questionId : filterQuestionIdByLikes) {
                for (QuestionCompanyMapping mapping : questionCompanyMappingList) {
                    if (mapping.getQuestionId().equals(questionId) && companySet.contains(companyDao.findById(mapping.getCompanyId()).get().getCompanyName())) {
                        filteredQuestionIdByCompany.add(questionId);
                    }
                }
            }
        }else{
            filteredQuestionIdByCompany = filterQuestionIdByLikes;
        }

        //Filtered by tags
        List<Tags> tagsList = tagsDao.findAll();
        ArrayList<String> filteredQuestionIdByTag = new ArrayList<>();
        if(tags != null){
            filteredQuestionIdByCompany.forEach(id->{
                tagsList.forEach(tag->{
                    if(tag.getQuestionId().equals(id) && tagSet.contains(tag.getTag())){
                        filteredQuestionIdByTag.add(id);
                    }
                });
            });
        }

        //Filtered by subTopics
        List<Topic> topicList = topicDao.findAll();
        ArrayList<String>filterQuestionIdByTopic = new ArrayList<>();
        if(subtopics != null){
            filteredQuestionIdByCompany.forEach(id->{
                topicList.forEach(topic->{
                    if(topic.getQuestionId().equals(id) && subtopics.contains(topic.getSubtopic())){
                        filterQuestionIdByTopic.add(id);
                    }
                });
            });
        }

        Set<String> selectedQuestionId = new HashSet<>();
        ArrayList<FilterQuestionOutput> result = new ArrayList<>();

        if(tags == null && subtopics == null){

            filteredQuestionIdByCompany.forEach(id->{

                final int[] likes = {(int) questionLikesList.stream().filter(like -> like.getQuestionId().equals(id)).count()};



                String question = questionDao.findById(id).get().getQuestion();
                ArrayList<String> companyForQuestionId = new ArrayList<>();
                for (QuestionCompanyMapping mapping : questionCompanyMappingList) {
                    if (mapping.getQuestionId().equals(id)){
                        companyForQuestionId.add(companyDao.findById(mapping.getCompanyId()).get().getCompanyName());
                    }
                }

                ArrayList<String> tagsForQuestionId = new ArrayList<>();
                tagsList.forEach(tag->{
                    if(tag.getQuestionId().equals(id)){
                        tagsForQuestionId.add(tag.getTag());
                    }
                });

                List<Answer> answerList = answerDao.findAll();
                final int[] maxLikes = {-1};
                final String[] bestAnswer = {"Not yet found"};
                /*
                Iterator<Answer> it = answerList.iterator();
                while(it.hasNext()){
                    if(it.next().getQuestionId().equals(id)){


                        List<AnswerLikes> answerLikesList = alDao.findAll();
                        int totalLikes = 0;
                        answerLikesList.for
                        int totalLikes = (int) answerLikesList.stream().filter(answerLike -> answerLike.getAnswerId().equals(it.next().getAnswerId())).count();
                        if( totalLikes > maxLikes[0]){
                            bestAnswer[0] = it.next().getAnswer();
                            maxLikes[0] = totalLikes;


                        }


                    }
                }*/
                System.out.println("Likes");
                answerList.forEach(answer->{
                    if(answer.getQuestionId().equals(id)){
                        List<AnswerLikes> answerLikesList = alDao.findAll();
                        int totalLikes = (int) answerLikesList.stream().filter(answerLike -> answerLike.getAnswerId().equals(answer.getAnswerId())).count();
                        if( totalLikes > maxLikes[0]){
                            bestAnswer[0] = answer.getAnswer();
                            maxLikes[0] = totalLikes;
                        }
                    }
                    System.out.println(bestAnswer[0]);
                    System.out.println(maxLikes[0]);
                });

                FilterQuestionOutput temp = new FilterQuestionOutput();
                temp.setLikes(likes[0]);
                temp.setQuestionId(id);
                temp.setQuestion(question);


                String[] finalCompanies = new String[companyForQuestionId.size()];
                Iterator<String> itCompany =  companyForQuestionId.iterator();
                int i = 0;
                while(itCompany.hasNext()){
                    finalCompanies[i] = itCompany.next();
                    i++;
                }
                temp.setCompanies(finalCompanies);

                String[] finalTags = new String[tagsForQuestionId.size()];
                Iterator<String> itTags =  tagsForQuestionId.iterator();
                i = 0;
                while(itTags.hasNext()){
                    finalTags[i] = itTags.next();
                    i++;
                }
                temp.setTags(finalTags);

                temp.setMostLikedAnswer(bestAnswer[0]);

                result.add(temp);

            });
        }else{
            if(tags != null){
                filteredQuestionIdByTag.forEach(id->{
                    selectedQuestionId.add(id);
                });
            }

            if(subtopics!=null){
                filterQuestionIdByTopic.forEach(id->{
                    selectedQuestionId.add(id);
                });
            }
        }

        FilterQuestionOutput[] finalResult = new FilterQuestionOutput[result.size()];
        Iterator<FilterQuestionOutput> it =  result.iterator();
        int i = 0;
        while(it.hasNext()){
            finalResult[i] = it.next();
            i++;
        }

        return new ResponseEntity<>(
                finalResult,
                HttpStatus.OK
        );
    }
}
