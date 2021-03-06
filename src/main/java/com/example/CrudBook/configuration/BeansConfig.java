package com.example.CrudBook.configuration;

import com.example.CrudBook.AOPlogging.Logging;
import com.example.CrudBook.model.Institution.InstitutionForm;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import com.example.CrudBook.model.User.Employee;
import com.example.CrudBook.model.User.Student;
import com.example.CrudBook.model.User.UserForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.io.IOException;

@Configuration
@EnableAspectJAutoProxy
public class BeansConfig {

    //In order for our Aspect to work we have to make it a bean and enable @EnalbeAspectjAutoProxy
    @Bean
    public Logging logging() {
        return new Logging();
    }

    @Bean
    public School school() {
        return new School();
    }

    @Bean
    public Workplace workplace() {
        return new Workplace();
    }

    @Bean
    public Employee employee() {
        return new Employee();
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public UserForm userForm() {
        return new UserForm();
    }

    @Bean
    public InstitutionForm institutionForm() {
        return new InstitutionForm();
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }
}
