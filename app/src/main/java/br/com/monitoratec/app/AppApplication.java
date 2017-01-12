package br.com.monitoratec.app;

import android.app.Application;

import br.com.monitoratec.app.dagger.DaggerDiComponent;
import br.com.monitoratec.app.dagger.DiComponent;
import br.com.monitoratec.app.dagger.module.ApplicationModule;

/**
 * Created by trindade on 12/01/17.
 */

public class AppApplication extends Application {

    private DiComponent mDiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mDiComponent = DaggerDiComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public DiComponent getDaggerDiComponent() {
        return mDiComponent;
    }

}
