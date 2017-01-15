package br.com.monitoratec.app.presentation.ui.followers;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import br.com.monitoratec.app.R;
import br.com.monitoratec.app.domain.entity.Follower;
import br.com.monitoratec.app.presentation.base.BaseActivity;
import br.com.monitoratec.app.presentation.ui.auth.AuthActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowersListActivity extends BaseActivity implements FollowerListContract.View {

    private static final String TAG = AuthActivity.class.getSimpleName();

    @BindView(R.id.followers_count_text)
    TextView mFollowerTxt;

    @Inject
    FollowerListContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_followers);
        ButterKnife.bind(this);
        super.getDaggerUiComponent().inject(this);
        mPresenter.setView(this);

        mPresenter.prepareFollowersCount();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onLoadFollowersComplete(List<Follower> followers) {
       mFollowerTxt.setText("You have " + followers.size() + " follower(s)");
    }

    @Override
    public void showError(String message) {
        mFollowerTxt.setText("Something unexpected happened!");
    }
}
