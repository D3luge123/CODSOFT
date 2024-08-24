package com.studentregistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface courseRepo extends JpaRepository<courses,Integer> {//repository interface, which extends JPA repostitory containing inbuilt methods for table creation and crud operations.
    
}
