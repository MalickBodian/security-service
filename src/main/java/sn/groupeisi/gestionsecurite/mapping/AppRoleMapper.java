package sn.groupeisi.gestionsecurite.mapping;
import sn.groupeisi.gestionsecurite.dto.AppRole;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;
import org.mapstruct.Mapper;
@Mapper
public interface AppRoleMapper {
    AppRole toAppRole(AppRoleEntity appRoleEntity); //  Transformation d'un DAO vers un DTO
    AppRoleEntity fromAppRole(AppRole appRole);  //  Transformation d'un TDO vers un DAO
}
