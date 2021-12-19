package com.ud.springJpa.SpringDataJpa.repository;

import com.ud.springJpa.SpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String fName);

    public List<Student> findByGuardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName,String lastName);


    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentNameByEmailAddress(String emailId);

    //NavtiveQuery
    @Query(
            value = "select * from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //NativeNamedQuery
    @Query(
            value = "select * from tbl_student s where s.email_address= :emailId and s.first_name= :name",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedQuery(@Param("emailId") String emailId, @Param("name") String name);

    //Modifying
    //transactional
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName,String emailId);


}
