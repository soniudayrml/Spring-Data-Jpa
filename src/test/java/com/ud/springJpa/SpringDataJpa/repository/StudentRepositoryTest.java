package com.ud.springJpa.SpringDataJpa.repository;

import com.ud.springJpa.SpringDataJpa.entity.Guardian;
import com.ud.springJpa.SpringDataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void saving()
//    {
//        Student student=Student.builder()
//                .emailId("soni@gmail.com")
//                .firstName("Uday")
//                .lastName("Soni")
////                .guardianName("Sindhi")
////                .guardianEmail("Sindhi@gmail.com")
////                .gurdianMobile("9284092561")
//                .build();
//
//        studentRepository.save(student);
//    }
    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian=Guardian.builder()
                  .name("Sindhi")
                .email("Sindhi@gmail.com")
                .mobile("9284092561")
                .build();

        Student student=Student.builder()
                .firstName("Naman")
                .lastName("Shah")
                .emailId("Naman@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void getByFirstName()
    {
        List<Student> students=studentRepository.findByFirstName("Naman");

        System.out.println("Student: "+students);
    }
    @Test
    public void getByFirstNameCon()
    {
        List<Student> students=studentRepository.findByFirstNameContaining("Nam");

        System.out.println("Student: "+students);
    }
    @Test
    public void getByGuardian()
    {
        List<Student> students=studentRepository.findByGuardianName("Sindhi");

        System.out.println("Student: "+students);
    }
    @Test
    public void getByBoth()
    {
        Student students=studentRepository.findByFirstNameAndLastName("Naman","Shah");

        System.out.println("Student: "+students);
    }
    @Test
    public void getByEmail()
    {

        Student students= studentRepository.getStudentByEmailAddress("Naman@gmail.com");
        System.out.println("Student: "+students);
    }

    @Test
    public void getName()
    {
        String name=studentRepository.getStudentNameByEmailAddress("Naman@gmail.com");
        System.out.println("Name: "+name);
    }

    @Test
    public void getStudentByEmailAddressNative()
    {
        Student student=studentRepository.getStudentByEmailAddressNative("Naman@gmail.com");
        System.out.println("Student: "+student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamed()
    {
        Student student=studentRepository.getStudentByEmailAddressNativeNamedQuery("Naman@gmail.com","Naman");
        System.out.println("Student: "+student);
    }

    @Test
    public void updateStudentNameByEmailId()
    {
        int i=studentRepository.updateStudentNameByEmailId("Naman Katkani","Naman@gmail.com");
        System.out.println("i: "+i);
    }
}