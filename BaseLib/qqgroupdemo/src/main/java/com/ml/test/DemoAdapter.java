package com.ml.test;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ml.expandable.ExpandableAdapter;
import com.ml.expandable.R;

import java.util.ArrayList;



public class DemoAdapter extends ExpandableAdapter<GroupBean,DemoAdapter.GroupViewHolder,UserBean,DemoAdapter.UserViewHolder> {





    public DemoAdapter(Context context, ArrayList<GroupBean> t) {
        super(context, t);
    }

    @Override
    public GroupBean getGroup(int postion) {
        return getList().get(postion);
    }

    @Override
    public UserBean getChild(GroupBean groupBean, int grouppostion, int childPostion) {
        return groupBean.getUserBeanList().get(childPostion);
    }

    @Override
    public int getChildCount(int groupBeanPostion) {
        if( getGroup(groupBeanPostion).getUserBeanList()!=null)
        return getGroup(groupBeanPostion).getUserBeanList().size();
        return 0;
    }

    @Override
    public int getGroupLayout() {
        return R.layout.group;
    }

    @Override
    public GroupViewHolder getGroupViewHolder(View v) {
        v.setBackgroundColor(Color.RED);
        return new GroupViewHolder(v);
    }

    @Override
    public void initGroupWidget(GroupViewHolder qqGroupAdapterViewHolder, View Groupview) {
        qqGroupAdapterViewHolder.groupName=findviewById(Groupview,R.id.groupName);
    }

    @Override
    public void bindGroupView(GroupViewHolder qqGroupAdapterViewHolder, GroupBean groupBean) {
        qqGroupAdapterViewHolder.groupName.setText(groupBean.getGroupName());
    }

    @Override
    public int getChildLayout() {
        return R.layout.user;
    }

    @Override
    public UserViewHolder getChildViewHolder(View view) {
        return new UserViewHolder(view);
    }

    @Override
    public void initChildViewWidget(UserViewHolder userViewHolder, View view) {
        userViewHolder.userName=findviewById(view,R.id.userName);
        userViewHolder.imageView=findviewById(view,R.id.img);
    }

    @Override
    public void bindChildView(UserViewHolder userViewHolder, UserBean b, int groupindex) {
        userViewHolder.userName.setText(b.getUserName());
        userViewHolder.imageView.setImageResource(b.getImgId());
    }

    public class GroupViewHolder extends ExpandableAdapter.ViewHolder{
        TextView groupName;
        public GroupViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class  UserViewHolder extends   ExpandableAdapter.ViewHolder{
        TextView userName;
        ImageView  imageView;

        public UserViewHolder(View itemView) {
            super(itemView);
        }
    }


}
