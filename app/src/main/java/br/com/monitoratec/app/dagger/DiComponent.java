package br.com.monitoratec.app.dagger;

import javax.inject.Singleton;

import br.com.monitoratec.app.MainActivity;
import br.com.monitoratec.app.dagger.module.ApplicationModule;
import br.com.monitoratec.app.dagger.module.NetworkModule;
import br.com.monitoratec.app.dagger.module.ServiceModule;
import dagger.Component;

/**
 * Created by trindade on 12/01/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        ServiceModule.class
})
public interface DiComponent {
    void inject(MainActivity activity);
}