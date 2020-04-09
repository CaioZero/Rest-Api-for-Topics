package com.springboot.javabrains.courseapi.repository;

import com.springboot.javabrains.courseapi.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** Class name, Atribute from Primary Key (that`is Id in this case)*/
@Repository
public interface TopicRepository extends JpaRepository<Topic,String>{
  
}