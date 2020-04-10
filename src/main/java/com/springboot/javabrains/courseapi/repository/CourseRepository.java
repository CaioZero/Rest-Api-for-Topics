package com.springboot.javabrains.courseapi.repository;

import java.util.List;

import com.springboot.javabrains.courseapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** Class name, Atribute from Primary Key (that`is Id in this case)*/
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    /* If the method findBY**** and the starts MATCHS with the field of a table
     and the Type of the variable (STRING at this case) MATCHS too
     they will automatically it will try to find by the field
    
     Examples:
     In this case, as you see, the method has Name after by, so they will search
     if the Model Course has a field call Name, and if it matches, it will verify
     if the variable (at this case abc) has the same type that field,
     at this case Name is a String and abc its a String too, so they matches!
     
     public List<Course> findByName(String abc);
     
     public List<Course> findByDescription(String abc);
    */

    /**
     * At this case, the method it will search at the Course Model and it will find 
     * a topic with the type Topic, so it will enter to the Topic model and will
     * find id as String type, so it will match and work!
    */
    public List<Course> findByTopicId(String topicId);
}