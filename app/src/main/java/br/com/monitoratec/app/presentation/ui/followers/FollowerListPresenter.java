package br.com.monitoratec.app.presentation.ui.followers;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.monitoratec.app.domain.repository.GitHubRepository;

/**
 * Created by falvojr on 1/13/17.
 */

public class FollowerListPresenter implements FollowerListContract.Presenter {

    private FollowerListContract.View mView;
    private GitHubRepository mGitHubRepository;
    @Inject
    @Named("secret")
    SharedPreferences mSharedPrefs;

    public FollowerListPresenter(GitHubRepository gitHubRepository) {
        mGitHubRepository = gitHubRepository;
    }

    @Override
    public void setView(FollowerListContract.View view) {
        mView = view;
    }

    @Override
    public void callGetFollowers(String username) {
        mGitHubRepository.getFollowers(username)
                .subscribe(followers -> {
                    mView.onLoadFollowersComplete(followers);
                }, error -> {
                    mView.showError(error.getMessage());
                });
    }

    @Override
    public void prepareFollowersCount() {
        String usernameKey = "USERNAME_KEY";
        String username = mSharedPrefs.getString(usernameKey, null);
        if (!username.isEmpty())
            callGetFollowers(username);
    }
}