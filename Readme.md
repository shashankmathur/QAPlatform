# API Doc

Base url- `http://qa3-env.eba-jepdn22a.us-east-2.elasticbeanstalk.com`

fixed path- `/api/v1`

1. ## CRUD API's for :

   * ## Company

    1. addCompany
        
            POST
            
            "/company"
            {
                "companyname":"name",
                "info":"info about company"
            }
    2. getCompany 
            
            GET

            "/company/{id}"

    3. deleteCompany 
            
            DELETE

            "/company/{id}"
    4. updateCompany 
            
            POST
            
            "/company/{id}"
            {
                "companyname":"name",
                "info":"info about company"
            }
    
    * ## Tag

    1. addTag
        
            POST
            
            "/tag"
            {
                "questionId":"String",
                "tag":"any tag"
            }
    2. getAllTags 
            
            GET

            "/tag/{id}"

    3. deleteTag 
            
            DELETE
            
            "/tag/{id}/{tag}"
    4. updateTag 
            
            POST
            
            "/tag/{id}/{tag}"
            {
                "questionId":"String",
                "tag":"any tag"
            }

    * ## Topic

    1. addTopic
        
            POST
            
            "/addTopic"
            {
                "questionId":"String",
                "topic":"any topic",
                "subtopic":"any subtopic"
            }

2. ## /POST Questions

                

        "/question"

        {
            "questionText" : "string of length more than 50 and less than 500",
            "companyId" : "Please refer to list of possible companies currently stored in db",
            "topicId" : "Refer below list",
            "subtopicId" : "Refer below list",
            "tags" : [
                "string",
                "string"
            ],
            "userId" : "Refer below list"
        }

3. ## /POST Answer

                

        "/answer"

        {
            "answer" : "string of length more than 50 and less than 500",
            "questionId" : "Refer below list",
            "userId" : "Refer below list"
        }

4. ## /POST Comments

                


        "/comment"

        {
            "comment" : "string of length more than 50 and less than 500",
            "answerId" : "Refer below list",
            "userId" : "Refer below list"
        }
    
5. ## /POST Question_likes

                

        "/question_likes"

        {
            "questionId" : "Refer below list",
            "userId" : "Refer below list"
        }

6. ## /POST Answer_likes

                

        "/answer_likes"

        {
            "answerId" : "Refer below list",
            "userId" : "Refer below list"
        }

7. ##  /GET Filter_Questions

                

        "/question?company=a,b,c&subtopic=q,w,e&likes=21&date="2019-12-10&tags=a,c,b"

8. ## /Get Question

        "/question/{id}"

# 

## Database content

I have already configured all the tables with sample data. So please test all get requests before posting anything as post request might lead to unstable state of DB if we dont choose values carefully.

This is list of values which can be chosen to make requests.

1. ### userId

    * us1
    * us2
    * us3
    * us4
    * us5

2. ### companyId

    * cp1
    * cp2
    * cp3
    * cp4
    * cp5

3. ### questionId

    * q1
    * q2
    * q3
    * q4
    * q5

4. ### answerId

    * an1
    * an2
    * an3
    * an4
    * an5

4. ### commentId

    * c1
    * c2
    * c3
    * c4
    * c5
    * c6
    * c7
    * c8
    * c9


# 

## Table to choose topicID and topic

| S.NO | topicId | topic          |
|------|---------|----------------|
| 1    | 1       | Data Structure |
| 2    | 2       | Algorithm      |

#

## Table to choose subtopicID and subtopic

| S.NO | subtopicId | subtopic    |
|------|------------|-------------|
| 1    | 1          | greedy algo |
| 2    | 2          | arrays      |
| 3    | 3          | sorting     |
| 4    | 4          | linked list |
| 5    | 5          | trees       |
    


    