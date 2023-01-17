package sn.groupeisi.gestionsecurite.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.groupeisi.gestionsecurite.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole extends BaseEntity {
    @NotNull(message = "Le nom ne doit pas etre null")
    private String name;
}
