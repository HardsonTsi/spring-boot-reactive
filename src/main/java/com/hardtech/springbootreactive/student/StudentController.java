package com.hardtech.springbootreactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
@RestController
public class StudentController {

    private final StudentService service;

    @GetMapping
    Flux<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/{id}")
    Mono<Student> findStudentById(@PathVariable Integer id) {
        return service.findStudentById(id);
    }


    @PostMapping
    Mono<Student> saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    void deleteStudentById(@PathVariable Integer id) {
        service.deleteStudentById(id);
    }

}
