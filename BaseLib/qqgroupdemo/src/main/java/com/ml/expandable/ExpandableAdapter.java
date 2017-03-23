package com.ml.expandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 *
 * @param <Group> group实体bean
 * @param <GroupViewHolder>  group viewhodler
 * @param <Child> group下的item的 bean
 * @param <ChildViewHolder>  itembean的viewhodler
 */

public abstract class ExpandableAdapter<Group,GroupViewHolder extends AppExpandableRecyleViewBaseAdapter.ViewHolder,Child,ChildViewHolder extends AppExpandableRecyleViewBaseAdapter.ViewHolder> extends AppExpandableRecyleViewBaseAdapter<Group,GroupViewHolder> {


    public ExpandableAdapter(Context context, ArrayList<Group> t) {
        super(context, t);
    }

    @Override
    protected int getLayout() {
        return getGroupLayout();
    }

    @Override
    protected void bindView(GroupViewHolder qqGroupAdapterViewHolder, Group groupBean) {
        bindGroupView( qqGroupAdapterViewHolder,  groupBean);
    }




    public  abstract Group getGroup(int postion);
    public abstract Child getChild(Group groupBean, int grouppostion, int childPostion);
    public abstract int  getChildCount(int  groupBeanPostion);


    @Override
    public void initKongjian(final GroupViewHolder qqGroupAdapterViewHolder, View linearLayout) {
        LinearLayout linearLayout1= (LinearLayout) linearLayout;
        int childCountcount=linearLayout1.getChildCount();
        if(childCountcount==2){
            LinearLayout linearLayout2= (LinearLayout) linearLayout1.getChildAt(1);
            int childCountcount2= linearLayout2.getChildCount();
            if(childCountcount2==getChildCount(qqGroupAdapterViewHolder.getPostion()))
            return;
            else {
                linearLayout1.removeView(linearLayout2);
            }
        }

        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final LinearLayout donw2=new LinearLayout(getContext());
        donw2.setOrientation(LinearLayout.VERTICAL);
        donw2.setLayoutParams(layoutParams);
        linearLayout1.addView(donw2);
        donw2.setVisibility(View.GONE);
        linearLayout1.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOpen=true;
                if(expandaleItemClick!=null){
                    isOpen= expandaleItemClick.groupClick(getGroup(qqGroupAdapterViewHolder.getPostion()));
                }
                if(isOpen){
                    if(donw2.getVisibility()!= View.VISIBLE){
                        donw2.setVisibility(View.VISIBLE);
                    }else {
                        donw2.setVisibility(View.GONE);
                    }
                }

            }
        });

        initGroupWidget( qqGroupAdapterViewHolder,   linearLayout1.getChildAt(0));
    }


    @Override
    protected void initChildWidget(GroupViewHolder holder, View linearLayout) {
        ViewGroup down2= (ViewGroup) ((ViewGroup) linearLayout).getChildAt(1);
        int count=getChildCount(holder.getPostion());
        if(count==down2.getChildCount()){
            //更新view
            for (int i=0;i<count;i++){
                View child = down2.getChildAt(i);
                ChildViewHolder childViewHolder= (ChildViewHolder) child.getTag();
                bindChildView(childViewHolder,getChild(getGroup(holder.getPostion()),holder.getPostion(),i),holder.getPostion());
            }
            return;//防止二次加载
        }
        for (int i=0;i<count;i++){
            View child = LayoutInflater.from(getContext()).inflate(getChildLayout(),null);

            ChildViewHolder childViewHolder=getChildViewHolder(child);
            initChildViewWidget(childViewHolder,child);
            childViewHolder.setPostion(i);
            Child child1=getChild(getGroup(holder.getPostion()),holder.getPostion(),i);

            setChildClick(child1,child);

            bindChildView(childViewHolder,child1,holder.getPostion());
            child.setTag(childViewHolder);
            down2.addView(child);
        }
    }
    private  void   setChildClick(final Child  child,View  view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandaleItemClick!=null){
                    expandaleItemClick.childClick(child);
                }
            }
        });
    }

    @Override
    public GroupViewHolder getViewHolder(View view) {
        return getGroupViewHolder(view);
    }





    public abstract int getGroupLayout();
    public abstract GroupViewHolder getGroupViewHolder(View groupview);
    public  abstract void initGroupWidget(GroupViewHolder groupViewHolder, View groupview);
    public abstract void bindGroupView(GroupViewHolder groupViewHolder, Group groupBean);

    public abstract int  getChildLayout();
    public  abstract ChildViewHolder  getChildViewHolder(View view);
    public  abstract  void initChildViewWidget(ChildViewHolder childViewHolder,View view);
    public  abstract  void bindChildView(ChildViewHolder childViewHolder, Child child,int groupindex);


    /**
     * 单击监听器
     * @param <Group>
     * @param <Child>
     */

    public  interface  ExpandaleItemClick<Group,Child>{

        /*
            boolean  open child list   yes or no ?
         */
        public boolean  groupClick(Group group);
        public void  childClick(Child child);
    }

    ExpandaleItemClick<Group,Child>  expandaleItemClick;

    public void setExpandaleItemClick(ExpandaleItemClick<Group,Child> expandaleItemClick) {
        this.expandaleItemClick = expandaleItemClick;
    }
}
