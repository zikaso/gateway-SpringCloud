package com.example.getway;



import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator
            (ReactiveDiscoveryClient  discoveryClient, DiscoveryLocatorProperties properties ){
        return  new  DiscoveryClientRouteDefinitionLocator(discoveryClient , properties);
    }


    /**
    // this is manual configuration has been disabled
    @Bean
    //this configuration with leadBalancer
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes()
                //This configuration with leadBalancer
                .route((r)-> r.path("/personnas/**").uri("lb://PERSONNA-SERVICE"))
                .route((r)-> r.path("/productoes/**").uri("lb://PRODUCTO-SERVICE"))

                // This is manual configuration
                //.route((r)-> r.path("/personnas/**").uri("http://localhost:8081/"))
                //.route((r)-> r.path("/productoes/**").uri("http://localhost:8082/"))

                // ex:http://localhost:8080/personnas
                // ex:http://localhost:8080/productoes
                // ex:http://localhost:8080/factoras

                .build();
  }


   // This an automatique configuration by  the Service name in the Url get mothde
   // ex:http://localhost:8080/PERSONNA-SERVICE/personnas
   // ex:http://localhost:8080/PRODUCTO-SERVICE/productoes
   // ex:http://localhost:8080/FACTORA-SERVICE/factoras
 **/





}
