package online.shopping.system.customer.service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "username")
    private int username;

    @Column(name = "password")
    private int password;

    @Column(name = "name")
    private int name;

    @Column(name = "email")
    private int email;

    @Column(name = "phone")
    private int phone;
}
