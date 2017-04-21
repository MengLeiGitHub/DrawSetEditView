package com.ml.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ml.expandable.ExpandableAdapter;
import com.ml.expandable.R;
import com.ml.expandablePlus.ExpandableView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2017-03-23.
 */

public class ExpandAblePlusActivity extends Activity  implements IListView<GroupBean>{

    ExpandableView recyclerView;
    IQueryPrenser iQueryPrenser;
    DemoAdapter demoAdapter;
    TextView  textView;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_plus);

        textView= (TextView) findViewById(R.id.text);
        recyclerView= (ExpandableView) findViewById(R.id.recy);

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
                        ViewGroup v= (ViewGroup) recyclerView.getChildAt(0);
                        textView.setText("recycle有"+v.getChildCount()+"个view");
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
