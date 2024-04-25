package com.example.user.service.service;

import com.example.user.service.model.entity.Address;
import com.example.user.service.model.request.CreateAddressRequest;
import com.example.user.service.model.response.AddressResponse;

public interface AddressService {

    Address getAddressById(long AddressId);

    AddressResponse insertAddress(CreateAddressRequest address);
}
