package com.studentregistration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
//creating courses table using spring jpa, entity annotation denoting creation of this table and data annotation for creating getters,setters,tostring and hash methods for these variables.
public class courses {
    @Id//denotes the primary key
    private int courseid;
    private String Course_name;
    private String Course_desc;
    private String schedule;
    private int Capacity;

    @Override
    public String toString() {//this is the format in which the courses would be shown, when this method is called by the service class, which is ultimately called by the main class.
        return "Course id: " + courseid + " - Course name: " + Course_name + " - Course description: " + Course_desc + " - Schedule: " + schedule + " - Capacity: " + Capacity; 
    }
}
