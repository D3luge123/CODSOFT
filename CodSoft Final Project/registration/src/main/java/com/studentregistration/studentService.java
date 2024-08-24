package com.studentregistration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
public class studentService {
   
    @Autowired
    private studentRepo studentrepo;

  student stu=new student();
    
   
     @Transactional
    public void registerStudent(int studentId, String studentName, String timeslot, java.util.Set<String> courseNames) {//method for registering a student into the db.

        // Create a new student object and set the properties.
        stu.setStudentid(studentId);
        stu.setStudent_name(studentName);
        stu.setTimeslot(timeslot);
        stu.setRegistered_Courses(String.join(", ", courseNames)); //storing registered courses as a single entity.
        
        // Save the student to the database.
        studentrepo.save(stu);
    }
    public void printStudentCourses(){//printing registered courses.

        System.out.println(stu.toString());
    }
    }
   

