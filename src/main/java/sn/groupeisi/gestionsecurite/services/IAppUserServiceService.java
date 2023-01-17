package sn.groupeisi.gestionsecurite.services;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

public interface IAppUserServiceService extends IBaseService<AppUserEntity> {
     AppUserEntity loaduser(MysqlxDatatypes.Scalar.String username);
     public AppUserEntity findById(int id);
     public void delete(int id);
     public AppUserEntity update(int id, AppUserEntity appUser);
}
