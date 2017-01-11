package br.com.monitoratec.app.domain;

import com.google.gson.GsonBuilder;

import br.com.monitoratec.app.domain.entity.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by trindade on 11/01/17.
 */

public interface GitHubAPI {

    String BASE_URL = "https://api.github.com/api/";
    Retrofit RETROFIT = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GitHubAPI.BASE_URL)
            .build();

    @GET("/user")
    Call<User> basicAuth(@Header("Authorization") String credentials);
}
