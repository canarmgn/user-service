package com.example.user.service.repository;

import com.example.user.service.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findByNo(String no);
    List<Address> findByCity(String city);
    List<Address> findByStreet(String street);

}