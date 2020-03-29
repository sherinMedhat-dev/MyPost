package pharos.solutions.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pharos.solutions.model.enums.PostStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {
    @NotBlank
    private String content;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PostStatus Status;
    @NotNull
    @ManyToOne(targetEntity = User.class)
    @JoinColumn( name = "creator_id")
    private User creator;

}
