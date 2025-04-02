package io.github.dursunkoc.mycustomerservice.service;

import io.github.dursunkoc.mycustomerservice.domain.*;
import io.github.dursunkoc.mycustomerservice.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {
    private Map<String,Customer> customers = new HashMap<>();

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    public Customer createCustomer(CustomerWrite customerWrite){
        Long id = getOrGenId(customerWrite.identityKey());
        List<CustomerContact> customerContacts = createCustomerContacts(customerWrite);
        CustomerDemographics customerDemographics = createCustomerDemographics(customerWrite);

        Customer customer = Customer.builder()
                .id(id)
                .identityKey(customerWrite.identityKey())
                .customerContacts(customerContacts)
                .customerDemographics(customerDemographics)
                .build();
        customers.put(customer.getIdentityKey(), customer);
        return customers.get(customer.getIdentityKey());
    }

    private Long getOrGenId(String identityKey) {
        if(customers.containsKey(identityKey)){
            return customers.get(identityKey).getId();
        }else{
            return ID_GENERATOR.incrementAndGet();
        }
    }

    private CustomerDemographics createCustomerDemographics(CustomerWrite customerWrite) {
        return CustomerDemographics.builder()
                .firstName(customerWrite.firstName())
                .lastName(customerWrite.lastName())
                .birthDate(customerWrite.birthDate())
                .occupation(customerWrite.occupation())
                .gender(Gender.of(customerWrite.gender()))
                .build();
    }

    private List<CustomerContact> createCustomerContacts(CustomerWrite customerWrite) {
        CustomerContactGsm customerContactGsm  = CustomerContactGsm.builder()
                .gsmNo(customerWrite.gsmNo())
                .build();
        CustomerContactEmail customerContactEmail = CustomerContactEmail.builder()
                .email(customerWrite.email())
                .build();
        return List.of(customerContactGsm, customerContactEmail);
    }

    public List<Customer> getAllCustomers() {
        return customers.values().stream().toList();
    }

    public Customer getCustomerByIdentity(String identityKey) {
        return customers.get(identityKey);
    }
}
