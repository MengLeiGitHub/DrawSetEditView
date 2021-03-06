package com.ml.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.ml.expandable.ExpandableAdapter;
import com.ml.expandable.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2017-03-23.
 */

public class ExpandAbleActivity extends Activity  implements IListView<GroupBean>{

    RecyclerView recyclerView;
    IQueryPrenser iQueryPrenser;
    DemoAdapter demoAdapter;
    TextView  textView;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);





        textView= (TextView) findViewById(R.id.text);
        recyclerView= (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(demoAdapter=new DemoAdapter(this,new ArrayList<GroupBean>()));
        demoAdapter.setExpandaleItemClick(new ExpandableAdapter.ExpandaleItemClick<GroupBean, UserBean>() {
            @Override
            public boolean groupClick(GroupBean groupBean) {

                Toast.makeText(getApplication(),"组名："+groupBean.getGroupName()+"  成员人数："+groupBean.getUserBeanList().size(),Toast.LENGTH_LONG).show();
                //true 表示打开列表  false 反之
                return true;
            }

            @Override
            public void childClick(UserBean userBean) {
                Toast.makeText(getApplication(),userBean.getUserName()+"",Toast.LENGTH_LONG).show();
            }
        });
        iQueryPrenser=new IQueryPrenser();
        iQueryPrenser.setGroupBeanIListView(this);
        iQueryPrenser.queryAll();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("recycle有"+recyclerView.getChildCount()+"个view");
                    }
                },4000);
            }
        },3000);






    }

    @Override
    public void setDatas(List<GroupBean> list) {
        demoAdapter.setData(list);
    }
}
