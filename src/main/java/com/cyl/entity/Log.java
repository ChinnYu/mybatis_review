package com.cyl.entity;

import java.util.Date;

/**
 * @author : Liu
 * @Date : 2019/11/8 下午 06:01
 * @Description :
 */

public class Log {
    private int id;
    private String content;
    private Date createTime;
    private boolean flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
