package com.example.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String tag;
    private Integer urgency;

    public Todo() {
    }

    public Todo(String _name, String _tag, Integer _urgency) {
        this.name = _name;
        this.tag = _tag;
        this.urgency = _urgency;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Todo setName(String _name) {
        this.name = _name;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Todo setTag(String _tag) {
        this.tag = _tag;
        return this;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public Todo setUrgency(Integer _urgency) {
        this.urgency = _urgency;
        return this;
    }
}
