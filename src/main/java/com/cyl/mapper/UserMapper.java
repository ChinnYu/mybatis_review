package com.cyl.mapper;

import com.cyl.entity.Log;
import com.cyl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> selectByUserName(User user);
    public List<User> selectByUserName2(User user);
    public List<User> selectByUserName3(User user);
    public List<User> selectByUserName4(User user);
    public long updateUser(User user);
    public long delByArray(int[] arr);
    public long delByList(List<Integer> list);



}
