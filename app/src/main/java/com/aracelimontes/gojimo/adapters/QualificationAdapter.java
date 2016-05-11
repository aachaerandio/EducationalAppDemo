package com.aracelimontes.gojimo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aracelimontes.gojimo.R;
import com.aracelimontes.gojimo.activities.DetailActivity;
import com.aracelimontes.gojimo.entity.Qualification;
import com.aracelimontes.gojimo.fragments.DetailFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araceli.montes on 10/05/2016.
 */
public class QualificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<Qualification> mData;
    protected Context mContext;
    protected FragmentManager mFm;

    public QualificationAdapter(FragmentManager fm, Context context) {
        mContext = context;
        mData = new ArrayList<>();
        mFm = fm;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qualification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder mHolder = (ViewHolder) holder;
        final Qualification qualification = mData.get(position);
        mHolder.name.setText(qualification.name);
        if(qualification.country != null && qualification.country.name != null) {
            mHolder.country.setText(qualification.country.name);
        }

        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(v.getContext(), DetailActivity.class);
                detail.putExtra(DetailFragment.ARG_ITEM, qualification);
                v.getContext().startActivity(detail);
            }
        });

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
        public TextView name, country;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            country = (TextView) v.findViewById(R.id.country);
        }
    }
}
