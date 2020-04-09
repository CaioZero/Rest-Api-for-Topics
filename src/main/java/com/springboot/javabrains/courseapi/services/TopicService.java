package com.springboot.javabrains.courseapi.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.springboot.javabrains.courseapi.model.Topic;

@Service
public interface TopicService {
    List<Topic> getAllTopics();

	Topic getTopic(String id);

	void createTopic(Topic topic);

	void updateTopic(String id, Topic topic);

	void deleteTopic(String id);
}