package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;

import java.util.Optional;

@Repository
public interface AppRoleRepository extends CrudRepository<AppRoleEntity, String> {
    Optional<AppRoleEntity> findByNameIgnoreCase(String name);
}
