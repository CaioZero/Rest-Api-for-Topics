package com.springboot.javabrains.courseapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="tb_course")
@Getter @Setter @NoArgsConstructor
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    /**Various Courses to one Topic */
    @ManyToOne
    private Topic topic;

    public Course(String id, String name, String description,String topicId) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.topic = new Topic(topicId,"","");
    }
}