package br.com.monitoratec.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import br.com.monitoratec.app.domain.GitHubAPI;
import br.com.monitoratec.app.domain.GitHubStatusAPI;
import br.com.monitoratec.app.domain.entity.GitHubStatus;
import br.com.monitoratec.app.domain.entity.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private TextView mTxtStatus;
    private TextInputLayout mTextInputUsername;
    private TextInputLayout mTextInputPassword;
    private Button mLogInButton;

    @BindView(R.id.ivGitHub)
    public ImageView mImgView;

    @Inject
    GitHubStatusAPI statusApiImpl;

    @Inject
    GitHubAPI gitHubAPI;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAppApplication().getDaggerDiComponent().inject(this);

        ButterKnife.bind(this);

        mImgView.setOnClickListener(view -> {
            Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
            mImgView.startAnimation(animation1);
        });
        mTxtStatus = (TextView) this.findViewById(R.id.txtStatus);
        mTextInputUsername = (TextInputLayout) this.findViewById(R.id.tilUsername);
        mTextInputPassword = (TextInputLayout) this.findViewById(R.id.tilPassword);

        
        mLogInButton = (Button) this.findViewById(R.id.loginButton);
        mLogInButton.setOnClickListener(view -> {
            boolean valid = true;
            if (mTextInputUsername.getEditText().getText().toString().isEmpty()) {
                mTextInputUsername.setError("Fill this field!");
                valid = false;
            }

            if (mTextInputPassword.getEditText().getText().toString().isEmpty()) {
                mTextInputPassword.setError("Fill this field!");
                valid = false;
            }

            if (valid) {
                final String username = mTextInputUsername.getEditText().getText().toString();
                final String password = mTextInputPassword.getEditText().getText().toString();
                String credentials = Credentials.basic(username, password);

                gitHubAPI.basicAuth(credentials).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            User user = response.body();
                            Snackbar.make(view, "Nome: " + user.getName(), Snackbar.LENGTH_LONG).show();
                        } else {
                            Snackbar.make(view, "Not Successful", Snackbar.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Snackbar.make(view, "Nome: " + "OnFailure", Snackbar.LENGTH_LONG).show();
                    }
                });

            }
        });


//        statusApiImpl.lastMessage().enqueue(new Callback<GitHubStatus>() {
//            @Override
//            public void onResponse(Call<GitHubStatus> call, Response<GitHubStatus> response) {
//                if (response.isSuccessful()) {
//                    GitHubStatus status = response.body();
//                    updateScreen(status);
//                } else {
//
//                    try {
//                        String error = response.errorBody().string();
//                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
//                    } catch (IOException e) {
//                        Log.e(TAG, e.getMessage());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GitHubStatus> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

//        statusApiImpl.lastMessage().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseSubscriber<GitHubStatus>() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNext(GitHubStatus gitHubStatus) {
//                        updateScreen(gitHubStatus);
//                    }
//                });


        statusApiImpl.lastMessage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gitHubStatus -> {
                            updateScreen(gitHubStatus);
                        }
                        ,
                        throwable -> {
                            Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                        });


        RxTextView.textChanges(mTextInputUsername.getEditText()).subscribe(charSequence -> {
            if (charSequence.toString().length() > 20) {
                int color = ContextCompat.getColor(MainActivity.this, R.color.colorTextRxBinding);
                mTextInputUsername.getEditText().setTextColor(color);
            }
        });


    }

    private void updateScreen(GitHubStatus status) {
        int color = ContextCompat.getColor(MainActivity.this, status.status.getColorId());
        mTxtStatus.setText(status.status.name());
        mTxtStatus.setTextColor(color);
        DrawableCompat.setTint(mImgView.getDrawable(), color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notifyId:
                String phone = "+34666777888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
