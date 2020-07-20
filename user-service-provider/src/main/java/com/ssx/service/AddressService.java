package com.ssx.service;

import com.ssx.bean.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByID(int addressID);
}
