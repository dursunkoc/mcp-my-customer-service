package io.github.dursunkoc.mycustomerservice.controller;

import io.github.dursunkoc.mycustomerservice.domain.Customer;
import io.github.dursunkoc.mycustomerservice.domain.CustomerWrite;
import io.github.dursunkoc.mycustomerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/new")
    public Mono<Customer> createCustomer(@RequestBody CustomerWrite customerWrite){
        return customerService.createCustomer(customerWrite);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{identityKey}")
    public Customer getCustomerByIdentity(@PathVariable String identityKey) {
        return customerService.getCustomerByIdentity(identityKey);
    }
}
