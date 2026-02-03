package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Optional<Task> getTaskById(int id) {
        return repo.findById(id);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

    public Task updateTask(int id, Task updatedTask) {
        return repo.findById(id).map(task -> {
            task.setName(updatedTask.getName());
            task.setDesp(updatedTask.getDesp());
            return repo.save(task);
        }).orElse(null);
    }
}