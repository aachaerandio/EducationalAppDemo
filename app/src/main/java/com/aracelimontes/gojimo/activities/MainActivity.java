package com.aracelimontes.gojimo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.aracelimontes.gojimo.CustomApiClient;
import com.aracelimontes.gojimo.R;
import com.aracelimontes.gojimo.adapters.QualificationAdapter;
import com.aracelimontes.gojimo.entity.Qualification;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager mLayoutManager;
    protected View mLoading;
    public CustomApiClient customApiClient;
    protected QualificationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Qualifications");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mLoading = findViewById(R.id.progressSpinner);
        mLoading.setVisibility(View.VISIBLE);

        mAdapter = new QualificationAdapter(getSupportFragmentManager(), this);
        mRecyclerView.setAdapter(mAdapter);
        
        customApiClient = new CustomApiClient();
        customApiClient.getService().listQualifications().enqueue(new Callback<List<Qualification>>() {
            @Override
            public void onResponse(Call<List<Qualification>> call, Response<List<Qualification>> response) {
                mLoading.setVisibility(View.GONE);
                if (response.body().size() > 0) {
                    mAdapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Qualification>> call, Throwable t) {
                mLoading.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error loading qualifications", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
