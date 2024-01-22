package com.example.api_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_interface {

    @GET("/photos")
    Call<List<UserModel>> getUser();

}
