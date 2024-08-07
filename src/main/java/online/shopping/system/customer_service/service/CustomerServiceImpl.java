package online.shopping.system.customer_service.service;

import online.shopping.system.customer_service.entity.Customer;
import online.shopping.system.customer_service.exception.BusinessException;
import online.shopping.system.customer_service.exception.constant.ErrorCode;
import online.shopping.system.customer_service.keycloak.dto.UserDTO;
import online.shopping.system.customer_service.keycloak.service.KeyCloakService;
import online.shopping.system.customer_service.repository.CustomerRepository;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    KeyCloakService keyCloakService;

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findByCustomerId(customerId).orElse(null);
    }

    @Override
    public void createCustomer(UserDTO userDTO) throws BusinessException {
        Optional<Customer> customer = customerRepository.findByUsername(userDTO.getUsername());
        if(customer.isPresent()){
            throw new BusinessException(ErrorCode.CUSTOMER_ALREADY_EXIST, userDTO.getUsername());
        }
        keyCloakService.addUser(userDTO);
        List<UserRepresentation> user = keyCloakService.getUser(userDTO.getUsername());

        String userId = user.get(0).getId();
        Customer newCustomer = Customer.builder()
                .username(userDTO.getUsername())
                .name(userDTO.getFirstname() + " " + userDTO.getLastName())
                .email(userDTO.getEmailId())
                .phone(userDTO.getPhone())
                .jwtId(userId)
                .createdOn(LocalDateTime.now())
                .lastModifiedOn(LocalDateTime.now())
                .build();
        customerRepository.save(newCustomer);
    }
}
