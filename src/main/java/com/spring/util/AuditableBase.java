package com.spring.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Data
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class AuditableBase {

    @CreatedBy
    @Column(name = "createdBy", updatable = false)
    private String createdBy;

    //@CreatedDate
    //@Column(name = "createdDate", updatable = false)
    //private Timestamp createdDate;

    @LastModifiedBy
    @Column(name = "modifiedBy")
    private String modifiedBy;

    //@LastModifiedDate
    //  @Column(name = "modifiedDate")
//    private Timestamp modifiedDate;
}
