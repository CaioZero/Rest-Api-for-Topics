package com.springboot.javabrains.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.springboot.javabrains.courseapi.model.Topic;
import com.springboot.javabrains.courseapi.services.TopicService;

@Api(value="API REST Topics")
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
@RestController
public class TopicController {

    /**Spring annotation that marks the injection of this dependency as services */
    @Autowired
    private TopicService topicService;

    @ApiOperation(value="Return All Topics")
    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @ApiOperation(value="Return One Topic")
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @ApiOperation(value="Create One Topic")
    @PostMapping("/topics")
    public void createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
        
    }

    @ApiOperation(value="Update One Topic")
    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable("id") String id, @RequestBody Topic topic) {
        topicService.updateTopic(id,topic);    
    }

    @ApiOperation(value="Delete One Topic")
    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable("id") String id) {
        topicService.deleteTopic(id);
    }

}