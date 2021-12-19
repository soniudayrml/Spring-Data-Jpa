package com.ud.springJpa.SpringDataJpa.controller;

import com.ud.springJpa.SpringDataJpa.entity.Student;
import com.ud.springJpa.SpringDataJpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public void saving(@RequestBody Student student)
    {
        studentRepository.save(student);
    }
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Student getStudent(@PathVariable Long id)
    {
        return studentRepository.getById(id);
    }

    @RequestMapping(value = "/student/firstName/{fname}",method = RequestMethod.GET)
    public List<Student> getByName(@PathVariable String fname)
    {
        return studentRepository.findByFirstName(fname);
    }
}
