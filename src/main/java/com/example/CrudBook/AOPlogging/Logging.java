package com.example.CrudBook.AOPlogging;

import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.User.Employee;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// I have implemented an Aspect logging system.The methods in this class will write to a file what the users
//adds to the database and will display the time he did that;
@Aspect
public class Logging {

    @Pointcut("execution(**concert.Perfromance.perform(..))")
    public void perfromance() {
    }

//    @Around("perfromance")
//    public User saveUserToFile() {
//        return new Employee();
//    }
//
//    @AfterReturning("performance")
//    public Institution saveInstitutionToFile() {
//        return new School();
//    }


}
