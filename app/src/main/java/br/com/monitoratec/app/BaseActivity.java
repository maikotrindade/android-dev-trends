package br.com.monitoratec.app;

import android.support.v7.app.AppCompatActivity;

import br.com.monitoratec.app.dagger.DiComponent;

/**
 * Created by trindade on 12/01/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected AppApplication getAppApplication() {
        return (AppApplication) getApplication();
    }

    protected DiComponent getDiComponent() {
        return this.getAppApplication().getDaggerDiComponent();
    }


}
