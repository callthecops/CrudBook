package com.example.CrudBook.AOPlogging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

// I have implemented an Aspect logging system.The methods in this class will write to a file what the users
//adds to the database and will display the time he did that;
@Aspect
public class Logging {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postAction() {

    }

    ///////// Pointcuts for Users
    @Pointcut("within(com.example.CrudBook.controller.EmployeeController)")
    public void employeeAction() {

    }

    @Pointcut("within(com.example.CrudBook.controller.StudentController)")
    public void studentAction() {

    }

    @Pointcut("within(com.example.CrudBook.controller.UserController)")
    public void userAction() {

    }

    //Advice for users

    @Before("postAction() && (employeeAction() || studentAction() || userAction())")
    public void beforePostUser(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String name = request.getParameter("firstName");
        logger.info(name);
    }



    /////////////////////////// Pointcuts for institutions


    @Pointcut("within(com.example.CrudBook.controller.InstitutionController)")
    public void institutionAction() {

    }

    @Pointcut("within(com.example.CrudBook.controller.SchoolController)")
    public void schoolAction() {

    }

    @Pointcut("within(com.example.CrudBook.controller.WorkPlaceController)")
    public void workplaceAction() {

    }


    //Advice for institutions


    @Before("postAction() && (institutionAction() || schoolAction() || workplaceAction())")
    public void beforePostInstitution(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String name = request.getParameter("name");
        logger.info(name);
    }




//    @Around("postAction()")
//    public void watchPerformance(ProceedingJoinPoint joinPoint) {
//        try {
//            //this happens before pointcut
//            System.out.println("Before starting the car2");
//            logger.info("Before Post");
//            joinPoint.proceed();
//            //this happens after pointcut
//            System.out.println("After post");
//            logger.warn("MODIFIED");
//        } catch (Throwable e) {
//            //if exception is thrown this happens
//            System.out.println("Error: " + e);
//        }
//    }


}
