package sn.groupeisi.gestionsecurite.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data @NoArgsConstructor @AllArgsConstructor
public class Base implements Serializable {
    private int id;
    @JsonIgnore
    private Date createdAt;
    @JsonIgnore
    private Date updatedAt;
}
