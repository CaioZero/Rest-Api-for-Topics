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

import com.springboot.javabrains.courseapi.model.Course;
import com.springboot.javabrains.courseapi.model.Topic;
import com.springboot.javabrains.courseapi.services.CourseService;

@Api(value="API REST Courses")
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    /**Spring annotation that marks the injection of this dependency as services */
    @Autowired
    private CourseService courseService;

    @ApiOperation(value="Return All Coursers")
    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable("topicId") String id){
        return courseService.getAllCourses(id);
    }

    @ApiOperation(value="Return One Course")
    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable("id") String id){
        return courseService.getCourse(id);
    }

    @ApiOperation(value="Create One Course")
    @PostMapping("/topics/{topicId}/courses")
    public void createCourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.createCourse(course);
        
    }

    @ApiOperation(value="Update One Course")
    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(
        @PathVariable("id") String id,
        @RequestBody Course course
        ,@PathVariable("topicId") String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);    
    }

    @ApiOperation(value="Delete One Course")
    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable("id") String id) {
        courseService.deleteCourse(id);
    }

}