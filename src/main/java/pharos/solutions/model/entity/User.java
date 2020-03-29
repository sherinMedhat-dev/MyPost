package pharos.solutions.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Table(name = "user")
@Entity
public class User extends BaseEntity {
    @NotBlank
    @Size(max = 50)
    @Column(name = "user_name")
    private String userName;
    @NotBlank
    @Size(max = 50)
    private String password;
    @NotBlank
    @Size(max = 200)
    @Column(name = "full_name")
    private String fullName;

}
