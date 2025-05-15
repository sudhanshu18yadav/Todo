package com.example.spring.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.spring.domain.Todo;
import com.example.spring.repository.TodoRepository;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TodoController {

    @Autowired
    TodoRepository repo;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/all")
    public Iterable<Todo> all(Model model) {
        model.addAttribute("name", "this from backend");
        return repo.findAll();
    }

    @PostMapping("/add")
    public Iterable<Todo> add(@RequestBody Todo todo, Model model) {
        repo.save(todo);
        return all(model);
    }

    @DeleteMapping("/delete")
    public Iterable<Todo> delete(@RequestBody Todo todo, Model model) {
        repo.delete(todo);
        return all(model);
    }

    @PatchMapping("/update")
    public Iterable<Todo> update(@RequestBody Todo todo, Model model) {
        var findTodo = repo.findById(todo.getId());
        if (findTodo != null)
            repo.save(findTodo.get());
        return all(model);
    }

    @GetMapping("/tag")
    public Iterable<Todo> update(@RequestParam String _tag) {
        var findTodo = repo.findByTag(_tag);
        if (findTodo == null)
            return new ArrayList<Todo>();
        return findTodo;
    }
}
