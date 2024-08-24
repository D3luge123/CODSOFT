package com.studentregistration;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class student {//entity annotation for table mapping and data for generating methods by lombok.
     @Id //primary key
     private int studentid;
    private String student_name;
    private String registered_Courses;
    private String timeslot;

    @Override
    public String toString() {//this is how registered courses would be displayed in the main method.
        return "Registered Courses:" + registered_Courses;
}
}
