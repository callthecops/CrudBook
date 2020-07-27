package com.example.CrudBook.AOPlogging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
        //This gives us access to the request object so that we can access the paramteres of the form
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String specialisation = request.getParameter("specialisation");
        String institution = request.getParameter("institution");
        String description = request.getParameter("description");
        logger.info("USER ACTION:User " + "|First Name: " + firstName + "|Last name: " + lastName + "|Age: " + age
                + "|Specialisation: " + specialisation + "|Institution: " + institution + "|Description: " + description);
    }

    @After("postAction() && (employeeAction() || studentAction() || userAction())")
    public void afterPostUser(JoinPoint joinPoint) {
        logger.info("ACTION PERFORMED");
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
        String address = request.getParameter("address");
        String institution = request.getParameter("institution");
        logger.info("USER ACTION:Institution " + "|Name: " + name + "|Address: " + address + "|Institution: " + institution);
    }

    @After("postAction() && (institutionAction() || schoolAction() || workplaceAction())")
    public void afterPostInstitution(JoinPoint joinPoint) {
        logger.info("ACTION PERFORMED");
    }

}
