package br.com.monitoratec.app.dagger;

import br.com.monitoratec.app.dagger.module.presentation.PresenterModule;
import br.com.monitoratec.app.dagger.scope.PerActivity;
import br.com.monitoratec.app.presentation.ui.auth.AuthActivity;
import br.com.monitoratec.app.presentation.ui.followers.FollowersListActivity;
import dagger.Subcomponent;

/**
 * Created by falvojr on 1/13/17.
 */
@PerActivity
@Subcomponent(modules = {PresenterModule.class})
public interface UiComponent {
    void inject(AuthActivity activity);
    void inject(FollowersListActivity activity);
}
