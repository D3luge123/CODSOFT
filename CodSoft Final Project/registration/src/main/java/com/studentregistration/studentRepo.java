package com.studentregistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
//repository interface that extends JPARepository, which takes two params: the class type with which it works and the datatype of primary key.
public interface studentRepo extends JpaRepository<student,Integer> {
    


    boolean existsBystudentid(int student_id);
    student findBystudentid(int studentId);
}
