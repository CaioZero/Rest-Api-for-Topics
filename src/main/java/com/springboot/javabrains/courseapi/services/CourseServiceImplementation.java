package com.springboot.javabrains.courseapi.services;

import java.util.ArrayList;
import java.util.List;

import com.springboot.javabrains.courseapi.repository.CourseRepository;
import com.springboot.javabrains.courseapi.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImplementation implements CourseService {

  @Autowired
  CourseRepository courseRepository;

  @Override
  public List<Course> getAllCourses(String topicId) {
    List<Course> courses = new ArrayList<>();
    /** For each elements i call the method again */
    courseRepository.findByTopicId(topicId)
    .forEach(courses::add);
    return courses;
  }

  @Override
  public Course getCourse(String id) {
    return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
  }

  @Override
  public void createCourse(Course course) {
      courseRepository.save(course);
  }

  @Override
  public void updateCourse(Course course) {
      /**At this method, they will only update if it finds some with the id */
    courseRepository.save(course);
  }

  @Override
  public void deleteCourse(String id) {
     courseRepository.deleteById(id);
  }


}