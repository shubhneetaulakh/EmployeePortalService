package com.socgen.employee_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Employee Portal
 *
 */
@SpringBootApplication(scanBasePackages = {"com.socgen"}) 
@EnableJpaRepositories("com.socgen.repository")
@EntityScan("com.socgen.entity")
public class EmployeePortal
{
    public static void main( String[] args )
    {
        SpringApplication.run(EmployeePortal.class, args);
    }
}
