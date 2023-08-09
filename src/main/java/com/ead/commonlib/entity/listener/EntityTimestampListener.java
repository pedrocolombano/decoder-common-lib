package com.ead.commonlib.entity.listener;


import com.ead.commonlib.entity.GenericEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EntityTimestampListener {

    @PrePersist
    public void prePersist(final GenericEntity entity) {
        entity.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        entity.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    }

    @PreUpdate
    public void preUpdate(final GenericEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    }

}
