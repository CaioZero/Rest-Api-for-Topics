package com.springboot.javabrains.courseapi.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.springboot.javabrains.courseapi.model.Course;

@Service
public interface CourseService {
    List<Course> getAllCourses(String topicId);

	Course getCourse(String id);

	void createCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(String id);

}