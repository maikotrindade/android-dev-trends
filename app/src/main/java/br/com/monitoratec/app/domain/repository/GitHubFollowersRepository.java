package br.com.monitoratec.app.domain.repository;

import br.com.monitoratec.app.domain.entity.Follower;
import rx.Observable;

/**
 * Created by trindade on 14/01/17.
 */

public interface GitHubFollowersRepository {

    Observable<Follower> getFollowers(String username);

}
