package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address find(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Long id, Address address) {
        Address dbAddress = find(id);

        dbAddress.setStreet(address.getStreet());
        dbAddress.setNo(address.getNo());
        dbAddress.setCity(address.getCity());
        dbAddress.setCountry(address.getCountry());
        dbAddress.setDescription(address.getDescription());

        return addressRepository.save(dbAddress);
    }

    public Address delete(Long id) {
        Address dbAddress = find(id);
        addressRepository.deleteById(id);
        return dbAddress;
    }
}
