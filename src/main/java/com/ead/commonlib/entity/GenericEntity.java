package com.ead.commonlib.entity;

import com.ead.commonlib.entity.listener.EntityTimestampListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(EntityTimestampListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class GenericEntity implements Serializable {

    private static final long serialVersionUID = -6115083087844626274L;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
