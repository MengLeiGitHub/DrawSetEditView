package com.ml.test;

import java.util.List;

/**
 * Created by admin on 2017-03-23.
 */

public class GroupBean {


    private String groupName;
    List<UserBean> userBeanList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UserBean> getUserBeanList() {
        return userBeanList;
    }

    public void setUserBeanList(List<UserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }
}
