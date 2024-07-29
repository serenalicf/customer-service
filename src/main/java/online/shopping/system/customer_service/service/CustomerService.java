package online.shopping.system.customer_service.service;

import online.shopping.system.customer_service.entity.Customer;
import online.shopping.system.customer_service.exception.BusinessException;
import online.shopping.system.customer_service.keycloak.dto.UserDTO;

public interface CustomerService {

    Customer getCustomer(Integer customerId);

    void createCustomer(UserDTO userDTO) throws BusinessException;
}
