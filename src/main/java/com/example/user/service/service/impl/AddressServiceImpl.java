package com.example.user.service.service.impl;

import com.example.user.service.model.entity.Address;
import com.example.user.service.model.entity.Users;
import com.example.user.service.model.request.CreateAddressRequest;
import com.example.user.service.model.response.AddressResponse;
import com.example.user.service.repository.AddressRepository;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    public Address getAddressById(long AddressId) {
        Address address = addressRepository.findById(AddressId).orElse(null);
        return address;
    }

    @Override
    public AddressResponse insertAddress(CreateAddressRequest address) {
        Optional<Users> user = userRepository.findById(address.getUserId());
        if (user.isPresent()) {
            Address newAddress = new Address();
            newAddress.setCity(address.getCity());
            newAddress.setStreet(address.getStreet());
            newAddress.setNo(address.getNo());
            newAddress.setUser(user.get());
            addressRepository.save(newAddress);

            AddressResponse response = new AddressResponse();
            response.setUserName(newAddress.getUser().getName());
            response.setCity(newAddress.getCity());
            response.setStreet(newAddress.getStreet());
            response.setNo(newAddress.getNo());

            return response;

        }

        return null;
    }
}
