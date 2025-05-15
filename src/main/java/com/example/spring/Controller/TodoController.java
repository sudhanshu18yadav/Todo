package com.example.spring.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring.domain.Todo;
import com.example.spring.repository.TodoRepository;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TodoController {

    @Autowired
    TodoRepository repo;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/all")
    public Iterable<Todo> all() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Iterable<Todo> add(@RequestBody Todo todo) {
        repo.save(todo);
        return all();
    }

    @DeleteMapping("/delete")
    public Iterable<Todo> delete(@RequestBody Todo todo) {
        repo.delete(todo);
        return all();
    }

    @PatchMapping("/update")
    public Iterable<Todo> update(@RequestBody Todo todo) {
        var findTodo = repo.findById(todo.getId());
        if (findTodo != null)
            repo.save(findTodo.get());
        return all();
    }

    @GetMapping("/tag")
    public Iterable<Todo> update(@RequestParam String _tag) {
        var findTodo = repo.findByTag(_tag);
        if (findTodo == null)
            return new ArrayList<Todo>();
        return findTodo;
    }
}
