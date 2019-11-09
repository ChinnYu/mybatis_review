package com.cyl.mapper;

import com.cyl.entity.Phone;
import com.cyl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PhoneMapper {

    public Phone getPhoneAndUser(int id);
    public Phone getPhoneAndUser2(int id);

}
