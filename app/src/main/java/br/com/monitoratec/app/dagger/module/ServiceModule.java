package br.com.monitoratec.app.dagger.module;

import javax.inject.Named;
import javax.inject.Singleton;

import br.com.monitoratec.app.domain.GitHubAPI;
import br.com.monitoratec.app.domain.GitHubStatusAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static br.com.monitoratec.app.dagger.module.NetworkModule.RETROFIT_GITHUB;
import static br.com.monitoratec.app.dagger.module.NetworkModule.RETROFIT_GITHUB_STATUS;

/**
 * Created by trindade on 12/01/17.
 */

@Module
public class ServiceModule {

    @Singleton
    @Provides
    GitHubAPI providesGitHub(
            @Named(RETROFIT_GITHUB) Retrofit retrofit) {
        return retrofit.create(GitHubAPI.class);
    }

    @Singleton
    @Provides
    GitHubStatusAPI providesGitHubStatus(
            @Named(RETROFIT_GITHUB_STATUS) Retrofit retrofit) {
        return retrofit.create(GitHubStatusAPI.class);
    }

}