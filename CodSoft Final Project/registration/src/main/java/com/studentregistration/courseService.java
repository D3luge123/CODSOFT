package com.studentregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class courseService {
    @Autowired
    private courseRepo courserepo;//creating courserepo object via dependency injection. It is connected by using Autowired annotation.

    public void fetchallCourses(){//method for fetching all courses.
        System.out.println("Here is the list of all your courses:");
        List<courses>courseList =courserepo.findAll();
        for(courses eachcourse:courseList){
            System.out.println(eachcourse.toString());
        }
    }
}
