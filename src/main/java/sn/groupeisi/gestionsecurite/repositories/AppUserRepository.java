package sn.groupeisi.gestionsecurite.repositories;

import com.google.common.base.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;
@Repository
public interface AppUserRepository extends CrudRepository<AppUserEntity, String> {
        Optional<AppUserEntity> findByNameIgnoreCase(String name);
}
