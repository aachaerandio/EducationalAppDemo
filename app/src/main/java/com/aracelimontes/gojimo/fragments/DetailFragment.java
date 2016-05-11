package com.aracelimontes.gojimo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aracelimontes.gojimo.R;
import com.aracelimontes.gojimo.adapters.DetailAdapter;
import com.aracelimontes.gojimo.entity.Qualification;

/**
 * Created by araceli.montes on 11/05/2016.
 */
public class DetailFragment extends Fragment {
    public static final String ARG_ITEM = "q_item";
    private Qualification mQItem;
    private DetailAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private View mEmptyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            mQItem = getArguments().getParcelable(ARG_ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        mEmptyView = rootView.findViewById(R.id.empty_view);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        if (mQItem != null && mQItem.subjects != null && !mQItem.subjects.isEmpty()) {
            mAdapter = new DetailAdapter(getContext(), mQItem.subjects);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mEmptyView.setVisibility(View.VISIBLE);
        }

        return rootView;
    }
}
