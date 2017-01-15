package br.com.monitoratec.app.presentation.ui.followers;

import java.util.List;

import br.com.monitoratec.app.domain.entity.Follower;

/**
 * Created by falvojr on 1/13/17.
 */
public interface FollowerListContract {

    interface View {
        void onLoadFollowersComplete(List<Follower> followers);

        void showError(String message);
    }

    interface Presenter {
        void setView(FollowerListContract.View view);

        void callGetFollowers(String username);

        void prepareFollowersCount();

    }
}
