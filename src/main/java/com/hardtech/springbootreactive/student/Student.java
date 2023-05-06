package com.hardtech.springbootreactive.student;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student {

    @Id
    Integer id;

    String firstname;

    String lastname;

    int age;

}
