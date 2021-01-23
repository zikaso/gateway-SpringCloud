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

    // this is manual configuration has been disabled
   // @Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes()

                // this is manual configuration

                //.route((r)-> r.path("/personnas/**").uri("http://localhost:8081/"))
                //.route((r)-> r.path("/factoras/**").uri("http://localhost:8082/"))
               // .build();

              //this configuration with leadBalancer
              //  .route((r)-> r.path("/personnas/**").uri("lb://PERSONNA-SERVICE"))
              //  .route((r)-> r.path("/factoras/**").uri("lb://FACTORA-SERVICE"))
              //  .build();

    }

   // this an automatique configuration by  the name in Client Url get mothde ex:http://localhost:8080/FACTORA-SERVICE/factoras
  @Bean
  DiscoveryClientRouteDefinitionLocator definitionLocator
          (ReactiveDiscoveryClient  discoveryClient, DiscoveryLocatorProperties properties ){
     return  new  DiscoveryClientRouteDefinitionLocator(discoveryClient , properties);
  }




}
