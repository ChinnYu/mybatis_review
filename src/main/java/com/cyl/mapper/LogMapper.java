package com.cyl.mapper;

import com.cyl.entity.Log;

import java.util.List;

public interface LogMapper {

    public Log selectLog(int id);

    public long insertLog(Log log);

    public long delById(int id);

    public long updateLog(Log log);

    public List<Log> list();
}
