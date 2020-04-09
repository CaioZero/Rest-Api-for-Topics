package com.springboot.javabrains.courseapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="tb_topic")
@Getter @Setter @NoArgsConstructor
public class Topic {
    
    @Id
    private String id;
    private String name;
    private String description;

    public Topic(String id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }
}