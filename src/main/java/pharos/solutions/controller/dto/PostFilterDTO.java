package pharos.solutions.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pharos.solutions.model.enums.PostStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostFilterDTO {

    @NotBlank
    @JsonProperty
    private String content;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PostStatus Status;
}
