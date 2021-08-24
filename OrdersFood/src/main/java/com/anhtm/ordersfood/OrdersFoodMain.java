package com.anhtm.ordersfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Orders food main.
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.anhtm.ordersfood.entity"})
@EnableJpaRepositories(basePackages = "com.anhtm.ordersfood.repository")
public class OrdersFoodMain {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(OrdersFoodMain.class, args);
    }
}
