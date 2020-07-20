package com.ssx.service.impl;

import com.ssx.bean.Address;
import com.ssx.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    com.ssx.mapper.AddressMapper AddressMapper;
    @Override
    public List<Address> getAddressByID(int addressID) {
        List<Address> list = AddressMapper.getAdressByID(addressID);
        return list;
    }
}
