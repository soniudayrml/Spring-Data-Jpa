package com.ud.springJpa.SpringDataJpa.repository;

import com.ud.springJpa.SpringDataJpa.entity.Course;
import com.ud.springJpa.SpringDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher()
    {
        List<Course> courses=new ArrayList<>();

        Course course1=Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Course course2=Course.builder()
                .title("OOP")
                .credit(6)
                .build();

        courses.add(course1);
        courses.add(course2);


        Teacher teacher=Teacher.builder()
                .firstName("Rakesh")
                .lastName("Mishra")
//                .courses(courses)
                .build();

        teacherRepository.save(teacher);

    }
}