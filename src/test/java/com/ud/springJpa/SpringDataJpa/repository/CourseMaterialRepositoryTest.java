package com.ud.springJpa.SpringDataJpa.repository;

import com.ud.springJpa.SpringDataJpa.entity.Course;
import com.ud.springJpa.SpringDataJpa.entity.CourseMaterial;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void saveCourseMaterial()
    {
        Course course= Course.builder()
                .title("CN")
                .credit(8)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.ipl.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void getCourseMaterrials()
    {
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println("CourseMaterials: "+courseMaterials);
    }

}