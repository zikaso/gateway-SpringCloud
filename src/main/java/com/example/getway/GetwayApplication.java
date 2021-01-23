package com.example.getway;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes()

                .route((r)-> r.path("/personnas/**").uri("http://localhost:8081/"))
                .route((r)-> r.path("/factoras/**").uri("http://localhost:8082/"))
                .build();
    }

}
