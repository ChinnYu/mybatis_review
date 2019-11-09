package com.cyl.mapper;

import com.cyl.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    public List<Order> listByTableName(@Param("tableName") String tablename);
}
