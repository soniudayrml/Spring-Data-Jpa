package com.ud.springJpa.SpringDataJpa.repository;

import com.ud.springJpa.SpringDataJpa.entity.Course;
import com.ud.springJpa.SpringDataJpa.entity.Student;
import com.ud.springJpa.SpringDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;



@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void printAllCourses()
    {
        List<Course> courses=courseRepository.findAll();
        System.out.println("Courses: "+courses);
    }
    @Test
    void saveCourse()
    {
        Course course=Course.builder()
                .title("Python")
                .credit(7)
                .build();

        courseRepository.save(course);
    }

    @Test
    void saveCourseWithTeacher()
    {
        Teacher teacher=Teacher.builder()
                .firstName("Ajay")
                .lastName("Makan")
                .build();

        Course course=Course.builder()
                .credit(9)
                .title("Spring")
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    void PaginationImpl()
    {
    Pageable firstPagewithThree= PageRequest.of(0,3);
        Pageable secondPagewithTwo= PageRequest.of(1,2);

        int pages=courseRepository.findAll(secondPagewithTwo).getTotalPages();
        System.out.println("Total Pages: "+pages);

        long totalElements=courseRepository.findAll(secondPagewithTwo).getTotalElements();
        System.out.println("Total Elements: "+totalElements);

        List<Course> courses=courseRepository.findAll(secondPagewithTwo).getContent();
        System.out.println("Courses: "+courses);

    }

    @Test
    void SortingImpl()
    {
        Pageable sortByTitle=PageRequest.of(0,2, Sort.by("title"));



        Pageable getByCreditDesc=PageRequest.of(0,5,Sort.by("credit").descending());

        List<Course> courses=courseRepository.findAll(getByCreditDesc).getContent();
        System.out.println("Courses: "+courses);
    }

    @Test
    void fromRepository()
    {
        Pageable getByPage=PageRequest.of(0,3,Sort.by("title").descending());
        List<Course> courses=courseRepository.findByTitleContaining("S",getByPage).getContent();
        System.out.println("Courses: "+courses);
    }

    @Test
    void TestingManyToMany()
    {
        Teacher teacher=Teacher.builder()
                .firstName("Suman")
                .lastName("Sharma")
                .build();

        Student student=Student.builder()
                .firstName("Ravi")
                .lastName("Singh")
                .emailId("Ravi@gmail.com")
                .build();

        Course course=Course.builder()
                .title("ML")
                .credit(10)
                .teacher(teacher)
                .build();
        course.saveStudent(student);

        courseRepository.save(course);
    }
}