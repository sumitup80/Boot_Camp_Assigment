package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RequestMapping(path = "/test")
@EnableDiscoveryClient
@SpringBootApplication  (scanBasePackages={"com.example.demo"})
public class DemoApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<Customer[]> findAll(){
       /* List<ServiceInstance> list =
                discoveryClient.getInstances("restapidemo");
        ServiceInstance service2 = list.get(0);
        URI micro2URI = service2.getUri();*/
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
        Customer[] customers = restTemplate.getForObject( "http://restapidemo/restdemo/customer/",
                Customer[].class);
        return new ResponseEntity<Customer[]>(customers
                ,new HttpHeaders(), HttpStatus.OK);
    }


}
