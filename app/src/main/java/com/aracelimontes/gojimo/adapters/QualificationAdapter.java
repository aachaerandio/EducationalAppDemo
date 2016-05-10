package com.aracelimontes.gojimo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aracelimontes.gojimo.R;
import com.aracelimontes.gojimo.entity.Qualification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araceli.montes on 10/05/2016.
 */
public class QualificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<Qualification> mData;
    private Context mContext;

    public QualificationAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qualification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder mHolder = (ViewHolder) holder;
        Qualification item = mData.get(position);
        mHolder.name.setText(item.name);

    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    public void setData(List<Qualification> qualifications) {
        mData.clear();
        mData.addAll(qualifications);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
        }
    }
}
