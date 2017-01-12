package br.com.monitoratec.app.dagger.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import br.com.monitoratec.app.domain.GitHubAPI;
import br.com.monitoratec.app.domain.GitHubStatusAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trindade on 12/01/17.
 */

@Module
public class NetworkModule {

    static final String RETROFIT_GITHUB = "GitHub";
    static final String RETROFIT_GITHUB_STATUS = "GitHubStatus";

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .create();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    @Named(RETROFIT_GITHUB)
    Retrofit providesRetrofitGitHub(GsonConverterFactory gsonFactory,
                                    RxJavaCallAdapterFactory rxFactory) {
        return buildRetrofit(gsonFactory, rxFactory,
                GitHubAPI.BASE_URL);
    }

    @Provides
    @Singleton
    @Named(RETROFIT_GITHUB_STATUS)
    Retrofit providesRetrofitGitHubStatus(GsonConverterFactory gsonFactory,
                                          RxJavaCallAdapterFactory rxFactory) {
        return buildRetrofit(gsonFactory, rxFactory,
                GitHubStatusAPI.BASE_URL);
    }

    private Retrofit buildRetrofit(GsonConverterFactory converterFactory,
                                   RxJavaCallAdapterFactory callAdapterFactory,
                                   String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

}
