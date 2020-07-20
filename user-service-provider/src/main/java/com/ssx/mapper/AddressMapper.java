package com.ssx.mapper;

import com.ssx.bean.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> getAdressByID(int userID);
}
