package com.example.anusirohi.constraintsdemologin.http;

import android.app.Activity;

import com.example.anusirohi.constraintsdemologin.model.register.RegisterRequest;
import com.example.anusirohi.constraintsdemologin.model.register.RegisterResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {
    private static Retrofit retrofit = null;

    private DataManager() {
    }

    private static class DataManagerSingleton {
        private static final DataManager INSTANCE = new DataManager();
    }

    public static DataManager getInstance() {
        return DataManagerSingleton.INSTANCE;
    }

    private ServiceInterface getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://aieeseprimary.co.in/aieApi/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ServiceInterface.class);
    }

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .build();


    public interface DataManagerListener {
        void onSuccess(Object response);

        void onError(Object response);
    }

    public void register(Activity activity, RegisterRequest registerRequest, final DataManagerListener dataManagerListener) {
        Call<RegisterResponse> call = getService().register(registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        dataManagerListener.onSuccess(response.body());
                    } else dataManagerListener.onError(response.body().getMessage());

                } else dataManagerListener.onError(response.errorBody());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                dataManagerListener.onError(t);
            }
        });
    }
}
