package com.example.user.service.controller;


import com.example.user.service.model.entity.Address;
import com.example.user.service.model.request.CreateAddressRequest;
import com.example.user.service.model.response.AddressResponse;
import com.example.user.service.repository.AddressRepository;
import com.example.user.service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    AddressRepository lRepo;

    @GetMapping("/address/{addressId}")
    public Address getAddressId(@PathVariable("addressId")long addressId){
        return addressService.getAddressById(addressId);
    }

    @GetMapping("/address/city")
    public List<Address> getAddressByCity(@RequestParam String city){
        return lRepo.findByCity(city);
    }

    @GetMapping("/address/street")
    public List<Address> getAddressByStreet(@RequestParam String street){
        return lRepo.findByStreet(street);
    }

    @GetMapping("/address/no")
    public List<Address> getAddressByNo(@RequestParam String no){
        return lRepo.findByNo(no);
    }

    @PostMapping("/address")
    public AddressResponse insertAddress(@RequestBody CreateAddressRequest address){
        return addressService.insertAddress(address);

    }

}
