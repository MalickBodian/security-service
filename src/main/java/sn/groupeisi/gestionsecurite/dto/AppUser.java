package sn.groupeisi.gestionsecurite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.groupeisi.gestionsecurite.entities.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends BaseEntity {
    private String firsName;
    private String lastName;
    private String email;
    private String password;

}
