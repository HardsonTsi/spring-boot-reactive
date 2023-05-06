package com.hardtech.springbootreactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public Flux<Student> findAllStudents() {
        return repository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findStudentById(Integer id) {
        return repository.findById(id);
    }

    public Mono<Student> saveStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudentById(Integer id) {
        repository.deleteById(id).subscribe();
    }

    @PostConstruct
    void saveMockStudents() {
        Random randomAge = new Random();
        List.of("TESSI", "Hardson", "Modeste", "Enagnon", "Sègla")
                .forEach(name -> saveStudent(Student.builder()
                        .lastname(name)
                        .firstname(name)
                        .age(randomAge.nextInt(18, 40))
                        .build()).subscribe());
    }


}
