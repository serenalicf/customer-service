package online.shopping.system.customer_service.service;

import online.shopping.system.customer_service.entity.Customer;
import online.shopping.system.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findByCustomerId(customerId).orElse(null);
    }
}
