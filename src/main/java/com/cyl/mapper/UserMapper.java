package com.cyl.mapper;

import com.cyl.entity.Log;
import com.cyl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public User selectUser(int id);

    public List<User> listByMap(Map<String,Object> map);
    public List<User> listByAnnotation (@Param("username") String username, @Param("note") String note);
    public List<User> listByObject (User user);
    public long insert (User user);

}
