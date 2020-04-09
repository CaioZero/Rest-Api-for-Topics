package com.springboot.javabrains.courseapi.services;

import java.util.ArrayList;
import java.util.List;

import com.springboot.javabrains.courseapi.repository.TopicRepository;
import com.springboot.javabrains.courseapi.model.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImplementation implements TopicService {

  @Autowired
  TopicRepository topicRepository;

  @Override
  public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<>();
    /** For each elements i call the method again */
    topicRepository.findAll().forEach(topics::add);
    return topics;
  }

  @Override
  public Topic getTopic(String id) {
    return topicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
  }

  @Override
  public void createTopic(Topic topic) {
      topicRepository.save(topic);
  }

  @Override
  public void updateTopic(String id, Topic topic) {
      /**At this method, they will only update if it finds some with the id */
    topicRepository.save(topic);
  }

  @Override
  public void deleteTopic(String id) {
     topicRepository.deleteById(id);;
  }


}