package online.shopping.system.customer_service.controller;

import online.shopping.system.customer_service.dto.CustomerDto;
import online.shopping.system.customer_service.entity.Customer;
import online.shopping.system.customer_service.mapper.CustomerMapper;
import online.shopping.system.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    @PostMapping("/customer/creation")
//    CustomerDto createCustomer(@Valid @RequestBody CustomerReqDto){
//        Customer customer = customerService.createCustomer(customerId);
//        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
//    }


    @GetMapping("/customers/{customerId}")
    CustomerDto getCustomer(@Validated @PathVariable("customerId") Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
    }

}
