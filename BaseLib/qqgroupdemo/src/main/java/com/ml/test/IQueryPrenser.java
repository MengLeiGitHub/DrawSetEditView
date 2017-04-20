package com.ml.test;

import com.ml.expandable.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2017-03-23.
 */

public class IQueryPrenser {
    public IListView<GroupBean> groupBeanIListView;

    public void setGroupBeanIListView(IListView<GroupBean> groupBeanIListView) {
        this.groupBeanIListView = groupBeanIListView;
    }

    public void  queryAll(){
        int[] drawables={R.drawable.q1,
                R.drawable.q2,
                R.drawable.q3,
                R.drawable.q4,
                R.drawable.q5,
                R.drawable.q6,
                R.drawable.q7,
                R.drawable.q8,
                R.drawable.q9,
                R.drawable.q10
        };

        List<GroupBean> groupBeen=new ArrayList<>();
        for (int i=0;i<25;i++){
            GroupBean groupBean=new GroupBean();
            groupBean.setGroupName("分组"+i);
            List<UserBean> userBeanList=new ArrayList<>();
            for (int j=0;j<5;j++){

                UserBean userBean=new UserBean();
                userBean.setUserName("用户"+i+j);
                userBean.setImgId(drawables[new Random().nextInt(10)]);
                userBeanList.add(userBean);

            }
            groupBean.setUserBeanList(userBeanList);
            groupBeen.add(groupBean);


        }
        groupBeanIListView.setDatas(groupBeen);


    }


}
