package com.ml.expandable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T> item的实体bean
 * @param <A> item的viewholder
 */
public abstract class AppExpandableRecyleViewBaseAdapter<T, A extends AppExpandableRecyleViewBaseAdapter.ViewHolder> extends RecyclerView.Adapter<A> {
    private List<T> list;
    Context context;
    private int position = -1;

    public AppExpandableRecyleViewBaseAdapter(Context context, ArrayList<T> t) {
        list = initList(context, t);
        this.context = context;
    }

    public List<T> getList() {
        return list;
    }

    public ArrayList<T> initList(Context context, ArrayList<T> t) {

        return t;
    }

    protected Context getContext() {
        return context;
    }

    public void addData(ArrayList<T> t) {
        list.addAll(t);
        notifyDataSetChanged();
    }

    public void setData(List<T> t) {
        list = t;
        notifyDataSetChanged();
    }

    public void clearAll() {
        list.clear();
        list = null;
        notifyDataSetChanged();
    }


    @Override
    public A onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(getLayout(), null);
        LinearLayout linearLayout=new LinearLayout(getContext());
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(view);
        A a = getViewHolder(linearLayout);
        initKongjian(a,linearLayout);
        return a;
    }

    @Override
    public void onBindViewHolder(A holder, int position) {
         T t = list.get(position);
        holder.setPostion(position);
        initChildWidget(holder,holder.getView());
        bindView(holder, t);

    }

    protected abstract void initChildWidget(A holder, View view);

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (list != null) return list.size();
        return 0;
    }

    public abstract A getViewHolder(View view);


    protected boolean isUseViewCache() {
        return true;
    }

    protected abstract int getLayout();

    protected abstract void bindView(A a, T t);

    public abstract void initKongjian(A a, View view);


    public int getPosition() {
        return position;
    }


    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        private int postion;
        private View view;
        A a;

        public void setPostion(int postion) {
            this.postion = postion;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

        }

        public int getPostion() {
            return postion;
        }

        public View getView() {
            return view;
        }

    }


    protected <N extends View> N findviewById(View view, int id) {

        return (N) view.findViewById(id);
    }

}
