package com.example.CrudBook.configuration;

import com.example.CrudBook.AOPlogging.Logging;
import com.example.CrudBook.model.Institution.Institution;
import com.example.CrudBook.model.Institution.School;
import com.example.CrudBook.model.Institution.Workplace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//Creating a JavaConfig Bean type autowiring configuration just for fun.

@Configuration
@EnableAspectJAutoProxy
public class InstitutionConfig {

    @Bean
    public Institution school() {
        return new School();
    }

    @Bean
    public Institution workPlace() {
        return new Workplace();
    }

    //In order for our Aspect to work we have to make it a bean and enable @EnalbeAspectjAutoProxy
    @Bean
    public Logging logging() {
        return new Logging();
    }


}
