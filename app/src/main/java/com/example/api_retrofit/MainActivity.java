package com.example.api_retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String api = "https://jsonplaceholder.typicode.com/photos";
    List<UserModel> userModels;
    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = findViewById(R.id.recyclerView);
        recView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().getApiInterface().getUser().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserModel>> call, @NonNull Response<List<UserModel>> response) {
                userModels = response.body();
                recView.setAdapter(new Adapter(MainActivity.this,userModels));
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("api", "onFailure" + t.getLocalizedMessage());
            }
        });


    }
}