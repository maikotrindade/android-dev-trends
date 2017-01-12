package br.com.monitoratec.app.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.monitoratec.app.domain.entity.GitHubStatus;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Interface da API GitHub GitHubStatus.
 * <p>
 * Created by falvojr on 1/9/17.
 */
public interface GitHubStatusAPI {

    String BASE_URL = "https://status.github.com/api/";
    Retrofit RETROFIT = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                    .create()))
            .baseUrl(GitHubStatusAPI.BASE_URL)
            .build();

    @GET("last-message.json")
    Observable<GitHubStatus> lastMessage();
}
