package com.aracelimontes.gojimo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aracelimontes.gojimo.R;
import com.aracelimontes.gojimo.entity.Subject;

import java.util.List;

/**
 * Created by araceli.montes on 11/05/2016.
 */
public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final List<Subject> mSubjects;

    public DetailAdapter(Context context, List<Subject> subjects) {
        mContext = context;
        mSubjects = subjects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        Subject subject = mSubjects.get(position);
        mHolder.title.setText(subject.title);
        mHolder.title.setBackgroundColor(Color.parseColor(subject.colour));
    }

    @Override
    public int getItemCount() {
        return (mSubjects == null) ? 0 : mSubjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
        }
    }
}
