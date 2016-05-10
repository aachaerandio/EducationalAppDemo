package com.aracelimontes.gojimo;

import com.aracelimontes.gojimo.entity.Qualification;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by araceli.montes on 10/05/2016.
 */
public class CustomApiClient {

    public static final String API_URL = "https://api.gojimo.net/api/v4/";

    public QualificationsService getService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QualificationsService.class);
    }

    public interface QualificationsService {
        @GET("qualifications")
        Call<List<Qualification>> listQualifications();
    }
}
