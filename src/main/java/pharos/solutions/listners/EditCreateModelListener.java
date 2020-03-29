package pharos.solutions.listners;

import pharos.solutions.model.entity.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class EditCreateModelListener {
    @PrePersist
    protected void setCreateUpdateFields(BaseEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        modifyRecord(entity);
    }

    @PreUpdate
    protected void setUpdateFields(BaseEntity entity) {
        modifyRecord(entity);
    }

    private void modifyRecord(BaseEntity entity) {
        entity.setModifiedAt(LocalDateTime.now());
    }

}
