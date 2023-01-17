package sn.groupeisi.gestionsecurite.services;

import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;

public interface IAppRoleServiceService extends IBaseService<AppRoleEntity> {
    public AppRoleEntity findByName(String name);
    public void delete(String name);
    public AppRoleEntity update(String name, AppRoleEntity appRoleEntity);
}
